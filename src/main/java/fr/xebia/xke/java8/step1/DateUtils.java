package fr.xebia.xke.java8.step1;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    private static final DateTimeFormatter DATE_PARSER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DateTimeFormatter DATE_TIME_PARSER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /**
     * Parse String date without times
     *
     * @param date format  yyyy-MM-dd
     * @return
     */
    public static LocalDate parseDate(String date) {
        //TODO: Replace with LocalDate
        return LocalDate.parse(date, DATE_PARSER);
    }

    /**
     * parse String date with time
     *
     * @param date format  yyyy-MM-dd'T'HH:mm:ss
     * @return
     */
    public static LocalDateTime parseDateTime(String date) {
        //TODO: Replace with LocalDateTime
        return LocalDateTime.parse(date, DATE_TIME_PARSER);
    }


    public static int age(LocalDate birthday, LocalDate now) {
        //TODO: Replace with LocalDate and use Period
        return Period.between(birthday, now).getYears();
    }

    public static LocalDateTime dayDateWithTime(LocalDate day, int hour, int minute, int second) {
        //TODO: Replace dayDate by LocalDate and result by LocalDateTime
        return day.atTime(hour, minute, second);
    }

    public static LocalDateTime addDuration(LocalDateTime date, int durationInMinute) {
        //TODO: Replace By LocalDateTime
        return date.plusMinutes(durationInMinute);
    }

    /**
     * @param firstDateWithTime  format  yyyy-MM-dd'T'HH:mm:ss
     * @param firstDateWithTime  format  yyyy-MM-dd'T'HH:mm:ss
     * @param secondDateWithTime format  yyyy-MM-dd'T'HH:mm:ss
     * @return
     */
    public static boolean dayAreEquals(LocalDateTime firstDateWithTime, LocalDateTime secondDateWithTime) {
        //TODO: Replace by LocalDateTime

        return firstDateWithTime.toLocalDate().equals(secondDateWithTime.toLocalDate());
    }

    public static String convertToTimeZone(String dateWithTime, ZoneId timeZoneFrom, ZoneId timeZoneTo) {
        //TODO: parse with LocalDateTime and use ZonedDateTime for conversion
        ZonedDateTime zoneDateTime = parseDateTime(dateWithTime).atZone(timeZoneFrom);
        return zoneDateTime.withZoneSameInstant(timeZoneTo).format(DATE_TIME_PARSER);
    }
}
