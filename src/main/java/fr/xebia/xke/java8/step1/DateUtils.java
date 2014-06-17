package fr.xebia.xke.java8.step1;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    /**
     * Parse String date without times
     *
     * @param date format  dd/MM/yyyy
     * @return
     */
    public static LocalDate parseDate(String date) {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return LocalDate.parse(date, format);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("bad format " + date);
        }
    }

    /**
     * parse String date with time
     *
     * @param date format  dd/MM/yyyy HH:mm:ss
     * @return
     */
    public static LocalDateTime parseDateTime(String date) {
        try {
        	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            return LocalDateTime.parse(date, format);
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("bad format " + date);
        }
    }

    public static int age(LocalDate birthday, LocalDate now) {
        return Period.between(birthday, now).getYears();
    }

    public static LocalDateTime dayDateWithTime(LocalDate dayDate, int hour, int minute, int second) {
        return dayDate.atTime(LocalTime.of(hour, minute, second));
    }

    public static LocalDateTime addDuration(LocalDateTime date, int minute) {
        return date.plusMinutes((long) minute);
    }

    public static boolean dayAreEquals(LocalDateTime firstDateWithTime, LocalDateTime secondDateWithTime) {
        return firstDateWithTime.getDayOfYear() == secondDateWithTime.getDayOfYear();
    }

    public static String convertToTimeZone(String dateWithTime, ZoneId timeZoneFrom, ZoneId timeZoneTo) {
        //TODO: parse with LocalDateTime and use ZonedDateTime for conversion
        try {
        	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime localDateTime = LocalDateTime.parse(dateWithTime, format);
            
            ZonedDateTime from = ZonedDateTime.of(localDateTime, timeZoneFrom);
            ZonedDateTime to = from.withZoneSameInstant(timeZoneTo);

            return to.format(format);

        } catch (DateTimeException e) {
            throw new IllegalArgumentException("bad format " + dateWithTime);
        }
    }
}
