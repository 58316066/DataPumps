package com.example.demo;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.demo.DataPumpMain.*;
import static com.example.demo.DataPumpProcess.*;

@Slf4j
public class DataPumping {


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
    public String pumping(final String field_format, int random) {
        if (field_format.toUpperCase().contains("EM0001")) {
            if (isEmployee_work_schedule) {
                String format1 = "";
                if (inIsEmployee == 0) {
                    countUp2();
                    inIsEmployee++;
                }
                if (inIsEmployee == 4) {
                    inIsEmployee = 1;
                    countUp2();
                }
                if (inIsEmployee != 0) {
                    format1 = ("EM" + count2[3] + count2[2] + count2[1] + count2[0]);
                    log.info(format1);
                    inIsEmployee++;
                }
                return format1;
            } else {
                countUp();
                final String format1 = ("EM" + count[3] + count[2] + count[1] + count[0]);
                log.info(format1);
                return format1;
            }
        } else if (field_format.toUpperCase().contains("FFFF LLLL")) {
            randomIdentifier();
            final String format2 = (firstName + " " + lastName);
            log.info(format2);
            return format2;
        } else if (field_format.toUpperCase().contains("FFFF")) {
            randomIdentifier();
            final String format3 = (firstName);
            log.info(format3);
            return format3;
        } else if (field_format.toUpperCase().contains("LLLL")) {
            final String format4 = (lastName);
            log.info(format4);
            return format4;
        } else if (field_format.toUpperCase().contains("MMMM")) {
            final String format4 = (middleName);
            log.info(format4);
            return format4;
        } else if (field_format.toUpperCase().contains("C|P")) {
            final String format6 = (randomChar(field_format));
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
            final String format7 = (days);
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
            final String format7 = (days);
            log.info(format7);
            return format7;
        } else if (field_format.toUpperCase().contains("TIME")) {
            time_fig++;
            if (time_fig > 6) {
                time_fig = 0;
            }
            String time = "00:00:00";
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
                    break;
            }
            final String format7 = (time);
            log.info(format7);
            return format7;
        } else if (field_format.contains("Single|Marry")) {
            final String[] split = field_format.split("\\|");
            final String format8 = (split[radgrt(split.length)]);
            log.info(format8);
            return format8;
        } else if (field_format.contains("Male|Female")) {
            final String[] split = field_format.split("\\|");
            final String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else if (field_format.toUpperCase().contains("AA")) {
            final String format10 = (String.valueOf(RandomNumber(27, 50)));
            log.info(format10);
            return format10;
        } else if (field_format.contains("Programmer|Tester|UX/UI|DataScience|DataEngineer")) {
            final String[] split = field_format.split("\\|");
            final String format10 = (split[radgrt(split.length)]);
            log.info(format10);
            return format10;
        } else if (field_format.toUpperCase().contains("WW0001")) {
            countUp();
            final String format1 = ("WW" + count[3] + count[2] + count[1] + count[0]);
            log.info(format1);
            return format1;
        } else if (field_format.contains("M|E|N")) {
            switch (rowNum) {
                case 1:
                    return "N";
                case 2:
                    return "E";
                case 3:
                    return "M";
                default:
                    return "Unknown";
            }
        } else if (field_format.contains("Morning|Evening|Night")) {
            switch (rowNum) {
                case 1:
                    return "Night";
                case 2:
                    return "Evening";
                case 3:
                    return "Morning";
                default:
                    return "Unknown";
            }
        } else if (field_format.contains("Monday")) {
            final String[] split = field_format.split("\\|");
            final String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else if (field_format.toUpperCase().contains("DETAIL")) {
            log.info("Detail");
            return "Detail";
        } else if (field_format.contains("S|P|V")) {
            final String[] split = field_format.split("\\|");
            final String format9 = (split[radgrt(split.length)]);
            log.info(format9);
            return format9;
        } else {
            log.info("matching NO , Default ==> \"DDDD\"");
            final String formatDefault = "DDDD";
            log.info(formatDefault);
            return formatDefault;
        }
    }

    private void countUp2() {
        counter2++;
        count2[0] = counter2 % 10;
        count2[1] = counter2 / 10 % 10;
        count2[2] = counter2 / 100 % 10;
        count2[3] = counter2 / 1000 % 10;
    }

    private void countUp() {
        counter++;
        count[0] = counter % 10;
        count[1] = counter / 10 % 10;
        count[2] = counter / 100 % 10;
        count[3] = counter / 1000 % 10;
    }

    private void randomIdentifier() {
        final Faker faker = new Faker();
        firstName = faker.name().firstName();
        middleName = faker.name().firstName();
        lastName = faker.name().lastName();
    }

    private String randomChar(final String field_format) {
        final String chars = field_format.replaceAll("\\|", "");
        final Random rnd = new Random();
        return String.valueOf(chars.charAt(rnd.nextInt(chars.length())));
    }

    private String randomDateTimes(final int fYear, final int fMonth, final int fDay, final int lYear, final int lMonth, final int lDay, final int fHour, final int fMinute, final int lHour, final int lMinute) {
        // Date
        final LocalDate startDate = LocalDate.of(fYear, fMonth, fDay); //start date
        final long start = startDate.toEpochDay();

        final LocalDate endDate = LocalDate.of(lYear, lMonth, lDay); //end date
        final long end = endDate.toEpochDay();
        final long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        // Time
        final LocalTime startTime = LocalTime.of(fHour, fMinute);
        final Long start_time = startTime.toNanoOfDay();

        final LocalTime endTime = LocalTime.of(lHour, lMinute);
        final Long end_time = endTime.toNanoOfDay();

        final long randomTime = ThreadLocalRandom.current().longs(start_time, end_time).findAny().getAsLong();

        final String date_times = LocalDate.ofEpochDay(randomEpochDay) + " " + LocalTime.ofNanoOfDay(randomTime).getHour() + ":" + LocalTime.ofNanoOfDay(randomTime).getMinute() + ":" + LocalTime.ofNanoOfDay(randomTime).getSecond();

        log.warn("date_times = " + date_times);

        return date_times;
    }

    private String randomDates(final int firstYear, final int lastYear, final int lastMonth, final int lastDay) {
        final LocalDate startDate = LocalDate.of(firstYear, 1, 1); //start date
        final long start = startDate.toEpochDay();

        final LocalDate endDate = LocalDate.of(lastYear, lastMonth, lastDay); //end date
        final long end = endDate.toEpochDay();

        final long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }

    private int radgrt(final int num) {
        return (int) Math.ceil(Math.random() * num) - 1;
    }


    private int RandomNumber(final int min, final int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        final Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
