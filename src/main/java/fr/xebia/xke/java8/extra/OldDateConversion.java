package fr.xebia.xke.java8.extra;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class OldDateConversion {

    public static Date toDate(LocalDate localDate) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, LocalTime.MIDNIGHT, ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static Date toDate(LocalDateTime localDateTime) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
        return Date.from(zonedDateTime.toInstant());
    }

    public static LocalDate toLocalDate(Date date) {
        return toLocalDateTime(date).toLocalDate();
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(GregorianCalendar gregorianCalendar) {
        return gregorianCalendar.toZonedDateTime().toLocalDateTime();
    }

    public static Calendar toCalendar(LocalDateTime localDateTime) {
        return GregorianCalendar.from(ZonedDateTime.of(localDateTime, ZoneId.systemDefault()));
    }
}
