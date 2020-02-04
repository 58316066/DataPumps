package com.example.demo;

import com.example.demo.errcode.ErrorCode;
import com.github.javafaker.Faker;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static com.example.demo.DataPumpMain.prop;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Data
@Slf4j
public class DataPumpProcess {
    private String field_name;
    private String row_num;
    private int row_number;
    private String dtp_file_name;

    public static List<String> field_config_name = new ArrayList<>();
    public static List<String> field_config_formats = new ArrayList<>();
    public static List<String> field_arg_name = new ArrayList<>();

    private List<String> createLine;
    public static List<List<String>> listDataPump = new ArrayList<>();
    private int[] count;
    public static int counter;
    //    private String firstName;
//    private String lastName;
//    private String days;
    public static int random = 0;
    private boolean check = false;
    int length_row_number = 0;
    private boolean statusDupFile = false;
    public static List<String> listDataFileOriginal;


    public DataPumpProcess(String field_name, String row_num, int row_number, String dtp_file_name) {
        this.field_name = field_name;
        this.row_num = row_num;
        this.row_number = row_number;
        this.dtp_file_name = dtp_file_name;
    }

    public void setupConfig() throws IOException, NoSuchAlgorithmException {
        log.info(String.valueOf(field_name));
        log.info(String.valueOf(row_num));

        String path_fileConfig = prop.getProperty("part.data_pump_fileConfig");
        File fileConfigFormat = new File(path_fileConfig);

        boolean checkFile = fileConfigFormat.isFile();

        log.info("CheckFile = " + checkFile);
        if (checkFile) {
            getFormat_Row(path_fileConfig);
            GenerateData();
            checkFileDuplicate();
            new DataPumpWriter().Writer(listDataPump, statusDupFile); // send data to writer
        } else {
            ErrorCode.toValidate("E1001", "!!! Cannot find configuration file !!!");
        }

    }

    private void checkFileDuplicate() throws IOException {
        BufferedReader bufferedReader = null;

        String pathFileOriginal = prop.getProperty("part.OutputCSV") + dtp_file_name + ".csv";
        statusDupFile = new File(pathFileOriginal).isFile();

        if (statusDupFile) {
            // read csv file
            listDataFileOriginal = new ArrayList<String>();
            File originalFile = new File(pathFileOriginal); //read output file

            try {
                bufferedReader = new BufferedReader(new FileReader(originalFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            String readLine = "";
            while ((readLine = bufferedReader.readLine()) != null) {
                listDataFileOriginal.add(readLine);
            }
        }
    }

    private void getFormat_Row(String path_fileConfig) throws IOException, NoSuchAlgorithmException {
        FileInputStream inputStream = null;
        XSSFWorkbook workbook = null;

        inputStream = new FileInputStream(path_fileConfig);
        workbook = new XSSFWorkbook(inputStream);

        int indexSheet = Integer.parseInt(prop.getProperty("fileConfig.indexSheet")); // get indexSheet
        XSSFSheet sheet = workbook.getSheetAt(indexSheet);
        System.out.println("Get Sheet Name ==> " + sheet.getSheetName());

        CreationHelper createHelper = workbook.getCreationHelper();
        XSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));

        int lastRowNum = sheet.getLastRowNum() - 3;

        log.info("lastRowNum = " + lastRowNum);
        for (int i = 1; i <= lastRowNum; i++) {
            Row row = sheet.getRow(i);

            Cell cellFieldName = row.getCell(1);
            Cell cellFormat = row.getCell(2);
            log.info("cellFieldName = \n" + cellFieldName);
            field_config_name.add(cellFieldName.getStringCellValue());
            field_config_formats.add(cellFormat.getStringCellValue());
        }
        log.info("field_config_name = \n" + field_config_name);
        log.info("field_config_formats = \n" + field_config_formats);

        /** parse field name array split "," */
        String field_names = field_name;
        String[] tokens = field_names.split("/");

        field_arg_name.addAll(Arrays.asList(tokens));

        log.info("field_arg_name = " + field_arg_name);
        log.info("field_arg_name = " + field_arg_name.size());

        listDataPump.add(field_arg_name);
    }

    private void GenerateData() {
        for (int loop = 0; loop < row_number; loop++) {
            DataPumping dataPumping = new DataPumping();
            random = 0;
            createLine = new ArrayList<>();
            for (String field_argument : field_arg_name) {
                check = false;
                for (int j = 0; j < field_config_name.size(); j++) {
                    if (field_argument.contains(field_config_name.get(j))) {
                        check = true;
                        String field_format = field_config_formats.get(j); // f = field_formats

                        /** DataPumping process running...
                         Data that has been return will add to arrayList createLine[]; **/
                        createLine.add(dataPumping.pumping(field_format, random));

                    }
                }
                if (!check) {
                    log.info("matching NO == > Default! " + field_config_name.get(field_config_name.size() - 1) + "create format ==> " + field_config_formats.get(field_config_name.size() - 1));
                    String formatDefault = "DDDD";
                    log.info(formatDefault);
                    createLine.add(formatDefault);
                }
            }
            listDataPump.add(createLine);
//            log.info("listDataPump = " + listDataPump);
        }
    }

}
