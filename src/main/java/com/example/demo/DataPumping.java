package com.example.demo;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.demo.DataPumpProcess.counter;

@Slf4j
public class DataPumping {

    private int[] count = new int[4];
    private String firstName;
    private String lastName;
    private String days;


    public String pumping(String field_format, int random) {

        if (field_format.toUpperCase().contains("AB0001")) {
            countUp();
            String format1 = ("AB" + count[3] + count[2] + count[1] + count[0]);
            log.info(format1);
            return format1;
        } else if (field_format.toUpperCase().contains("FFFF LLLL")) {
            randomIdentifier();
            String format2 = (firstName + " " + lastName);
            log.info(format2);
            return format2;
        } else if (field_format.toUpperCase().contains("FFFF")) {
            String format3 = (firstName);
            log.info(format3);
            return format3;
        } else if (field_format.toUpperCase().contains("LLLL")) {
            String format4 = (lastName);
            log.info(format4);
            return format4;
        } else if (field_format.toUpperCase().contains("JJ")) {
            String format5 = (String.valueOf(RandomNumber(10, 20)));
            log.info(format5);
            return format5;
        } else if (field_format.toUpperCase().contains("C|P")) {
            String format6 = (randomChar());
            log.info(format6);
            return format6;
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
        } else if (field_format.contains("Single|Marry")) {
            String[] status = {"Single", "Marry"};
            String format8 = (status[radgrt()]);
            log.info(format8);
            return format8;
        } else if (field_format.contains("Male|Female")) {
            String[] sex = {"Male", "Female"};
            String format9 = (sex[radgrt()]);
            log.info(format9);
            return format9;
        } else if (field_format.toUpperCase().contains("AA")) {
            String format10 = (String.valueOf(RandomNumber(27, 50)));
            log.info(format10);
            return format10;
        } else {
            log.info("matching NO , Default ==> \"DDDD\"");
            String formatDefault = "DDDD";
            log.info(formatDefault);
            return formatDefault;
        }
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
        lastName = faker.name().lastName();
    }

    private String randomChar() {
        String chars = "CP";
        Random rnd = new Random();
        return String.valueOf(chars.charAt(rnd.nextInt(chars.length())));
    }

    private String randomDates(int firstYear, int lastYear, int lastMonth, int lastDay) {
        LocalDate startDate = LocalDate.of(firstYear, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(lastYear, lastMonth, lastDay); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }

    private int radgrt() {
        return (int) Math.ceil(Math.random() * 2) - 1;
    }

    private int RandomNumber(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
