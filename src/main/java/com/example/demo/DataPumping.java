package com.example.demo;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.demo.DataPumpProcess.counter;
import static com.example.demo.DataPumpProcess.time_fig;
import static com.example.demo.DataPumpProcess.datetime;

@Slf4j
public class DataPumping {

    private int[] count = new int[4];
    private String firstName;
    private String lastName;
    private String days;
    private String middleName;


    // for พี่กุล
//    public String pumping(String field_format, int random) {
//        if (field_format.toUpperCase().contains("AB0001")) {
//            countUp();
//            String format1 = ("AB" + count[3] + count[2] + count[1] + count[0]);
//            log.info(format1);
//            return format1;
//        } else if (field_format.toUpperCase().contains("FFFF LLLL")) {
//            randomIdentifier();
//            String format2 = (firstName + " " + lastName);
//            log.info(format2);
//            return format2;
//        } else if (field_format.toUpperCase().contains("FFFF")) {
//            String format3 = (firstName);
//            log.info(format3);
//            return format3;
//        } else if (field_format.toUpperCase().contains("LLLL")) {
//            String format4 = (lastName);
//            log.info(format4);
//            return format4;
//        } else if (field_format.toUpperCase().contains("JJ")) {
//            String format5 = (String.valueOf(RandomNumber(10, 20)));
//            log.info(format5);
//            return format5;
//        } else if (field_format.toUpperCase().contains("C|P")) {
//            String format6 = (randomChar(field_format));
//            log.info(format6);
//            return format6;
//        } else if (field_format.toUpperCase().contains("YYYY-MM-DD")) {
//            random++;
//            switch (random) {
//                case 1:
//                    days = randomDates(1957, 1997, 1, 1);
//                    break;
//                case 2:
//                    days = randomDates(2019, 2020, 1, 1);
//                    break;
//                case 3:
//                    days = randomDates(2018, 2018, 12, 31);
//                    break;
//                default:
//                    days = randomDates(1997, 2020, 1, 1);
//                    break;
//            }
//            String format7 = (days);
//            log.info(format7);
//            return format7;
//        } else if (field_format.contains("Single|Marry")) {
//            String[] split = field_format.split("\\|");
//            String format8 = (split[radgrt(split.length)]);
//            log.info(format8);
//            return format8;
//        } else if (field_format.contains("Male|Female")) {
//            String[] split = field_format.split("\\|");
//            String format9 = (split[radgrt(split.length)]);
//            log.info(format9);
//            return format9;
//        } else if (field_format.toUpperCase().contains("AA")) {
//            String format10 = (String.valueOf(RandomNumber(27, 50)));
//            log.info(format10);
//            return format10;
//        } else {
//            log.info("matching NO , Default ==> \"DDDD\"");
//            String formatDefault = "DDDD";
//            log.info(formatDefault);
//            return formatDefault;
//        }
//    }


    // for น้องๆฝึกงาน
    public String pumping(String field_format, int random) {
        if (field_format.toUpperCase().contains("EM0001")) {
            countUp();
            String format1 = ("EM" + count[3] + count[2] + count[1] + count[0]);
            log.info(format1);
            return format1;
        } else if (field_format.toUpperCase().contains("FFFF LLLL")) {
            randomIdentifier();
            String format2 = (firstName + " " + lastName);
            log.info(format2);
            return format2;
        } else if (field_format.toUpperCase().contains("FFFF")) {
            randomIdentifier();
            String format3 = (firstName);
            log.info(format3);
            return format3;
        } else if (field_format.toUpperCase().contains("LLLL")) {
            String format4 = (lastName);
            log.info(format4);
            return format4;
        } else if (field_format.toUpperCase().contains("MMMM")) {
            String format4 = (middleName);
            log.info(format4);
            return format4;
        } else if (field_format.toUpperCase().contains("C|P")) {
            String format6 = (randomChar(field_format));
            log.info(format6);
            return format6;
        } else if (field_format.toUpperCase().contains("YYYY-MM-DD HH:MM:SS")) {
            datetime++;

            if (datetime > 6) {
                datetime = 0;
            }

            switch (datetime) {
                case 1:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 7, 0, 9, 0);
                    break;
                case 2:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 14, 0, 15, 0);
                    break;
                case 3:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 15, 0, 17, 0);
                    break;
                case 4:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 22, 0, 23, 0);
                    break;
                case 5:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 23, 0, 23, 59);
                    break;
                case 6:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 6, 0, 7, 0);
                    break;
                default:
                    days = randomDateTimes(2020, 1, 1, 2020, 1, 2, 0, 0, 0, 1);
                    break;
            }
            String format7 = (days);
            log.info(format7);
            return format7;
        } else if (field_format.toUpperCase().contains("YYYY-MM-DD")) {
            random++;
            switch (random) {
                case 1:
                    days = randomDates(1957, 1997, 1, 1);
                    break;
                case 2:
                    days = randomDates(2019, 2020, 1, 1);
                    break;
                case 3:
                    days = randomDates(2018, 2018, 12, 31);
                    break;
                default:
                    days = randomDates(1997, 2020, 1, 1);
                    break;
            }
            String format7 = (days);
            log.info(format7);
            return format7;
        } else if (field_format.toUpperCase().contains("HH:MM:SS")) {
            time_fig++;
            String time = "00:00:00";
            if (time_fig <= 6) {
                switch (time_fig) {
                    case 1:
                        time = "07:00:00";
                        break;
                    case 2:
                        time = "15:00:00";
                        break;
                    case 3:
                        time = "15:00:00";
                        break;
                    case 4:
                        time = "23:00:00";
                        break;
                    case 5:
                        time = "23:00:00";
                        break;
                    case 6:
                        time = "07:00:00";
                        break;
                    default:
                        time = time;
                        break;
                }
                String format7 = (time);
                log.info(format7);
                return format7;
            } else {
                time_fig = 0;
            }
        } else if (field_format.contains("Single|Marry")) {
            String[] split = field_format.split("\\|");
            String format8 = (split[radgrt(split.length)]);
            log.info(format8);
            return format8;
        } else if (field_format.contains("Male|Female")) {
            String[] split = field_format.split("\\|");
            String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else if (field_format.toUpperCase().contains("AA")) {
            String format10 = (String.valueOf(RandomNumber(27, 50)));
            log.info(format10);
            return format10;
        } else if (field_format.contains("Programmer|Tester|UX/UI|DataScience|DataEngineer")) {
            String[] split = field_format.split("\\|");
            String format10 = (split[radgrt(split.length)]);
            log.info(format10);
            return format10;
        } else if (field_format.toUpperCase().contains("WW0001")) {
            countUp();
            String format1 = ("WW" + count[3] + count[2] + count[1] + count[0]);
            log.info(format1);
            return format1;
        } else if (field_format.contains("M|E|N")) {
            String[] split = field_format.split("\\|");
            log.info("sss.length = " + split.length);
            String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else if (field_format.contains("Sunday|Monday|Tuesday|Wednesday|Thursday|Friday|Saturday")) {
            String[] split = field_format.split("\\|");
            String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else if (field_format.toUpperCase().contains("DETAIL")) {
            log.info("Detail");
            return "Detail";
        } else {
            log.info("matching NO , Default ==> \"DDDD\"");
            String formatDefault = "DDDD";
            log.info(formatDefault);
            return formatDefault;
        }
        return "DDDD";
    }

    private void countUp() {
        counter++;
        count[0] = counter % 10;
        count[1] = counter / 10 % 10;
        count[2] = counter / 100 % 10;
        count[3] = counter / 1000 % 10;
    }

    private void randomIdentifier() {
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        middleName = faker.name().firstName();
        lastName = faker.name().lastName();
    }

    private String randomChar(String field_format) {
        String chars = field_format.replaceAll("\\|", "");
        Random rnd = new Random();
        return String.valueOf(chars.charAt(rnd.nextInt(chars.length())));
    }

    private String randomDateTimes(int fYear, int fMonth, int fDay, int lYear, int lMonth, int lDay, int fHour, int fMinute, int lHour, int lMinute) {
        // Date
        LocalDate startDate = LocalDate.of(fYear, fMonth, fDay); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(lYear, lMonth, lDay); //end date
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        // Time
        LocalTime startTime = LocalTime.of(fHour, fMinute);
        Long start_time = startTime.toNanoOfDay();

        LocalTime endTime = LocalTime.of(lHour, lMinute);
        Long end_time = endTime.toNanoOfDay();

        long randomTime = ThreadLocalRandom.current().longs(start_time, end_time).findAny().getAsLong();

        String date_times = LocalDate.ofEpochDay(randomEpochDay) + " " + LocalTime.ofNanoOfDay(randomTime).getHour() + ":" + LocalTime.ofNanoOfDay(randomTime).getMinute() + ":" + LocalTime.ofNanoOfDay(randomTime).getSecond();

        log.warn("date_times = " + date_times);

        return date_times;

//        LocalDateTime startDateTime = LocalDateTime.of(fYear, fMonth, fDay, fHour, fMinute);
//        LocalDateTime endDateTime = LocalDateTime.of(lYear, lMonth, lDay, lHour, lMinute);
//
//
//        long start = startDateTime.toEpochSecond();
//
//        LocalDate endDate = LocalDate.of(lastYear, lastMonth, lastDay); //end date
//        long end = endDate.toEpochDay();
//
//        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
//        LocalDateTime.of
//        return String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }

    private String randomDates(int firstYear, int lastYear, int lastMonth, int lastDay) {
        LocalDate startDate = LocalDate.of(firstYear, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(lastYear, lastMonth, lastDay); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }

    private int radgrt(int num) {
        return (int) Math.ceil(Math.random() * num) - 1;
    }


    private int RandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
