package fr.xebia.xke.java8.extra;

import fr.xebia.xke.test.TemporalAccessorAssert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

public class OldDateConversionTest {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Test
    public void should_convert_LocalDate_to_date() {
        //Given
        LocalDate localDate = LocalDate.of(2014, 5, 1);

        //When
        Date date = OldDateConversion.toDate(localDate);

        //Then
        assertThat(date).isInSameDayAs("2014-05-01");
    }

    @Test
    public void should_convert_LocalDateTime_to_date() {
        //Given
        LocalDateTime localDateTime = LocalDateTime.of(2014, 5, 1, 17, 5, 12);

        //When
        Date date = OldDateConversion.toDate(localDateTime);

        //Then
        assertThat(date)
                .isInSameDayAs("2014-05-01")
                .isWithinHourOfDay(17)
                .isWithinMinute(5)
                .isWithinSecond(12);
    }

    @Test
    public void should_convert_date_to_LocalDate() throws ParseException {
        //Given
        Date date = format.parse("15/08/2013 18:05:55");

        //When
        LocalDate localDate = OldDateConversion.toLocalDate(date);

        //Then
        TemporalAccessorAssert.assertThat(localDate).isInSameDayAs("2013-08-15");
    }

    @Test
    public void should_convert_date_to_LocalDateTime() throws ParseException {
        //Given
        Date date = format.parse("15/08/2013 18:05:55");

        //When
        LocalDateTime localDateTime = OldDateConversion.toLocalDateTime(date);

        //Then
        TemporalAccessorAssert.assertThat(localDateTime)
                .isInSameDayAs("2013-08-15")
                .isWithinHourOfDay(18)
                .isWithinMinute(5)
                .isWithinSecond(55);
    }

    @Test
    public void should_convert_gregorian_calendar_to_localDateTime() throws ParseException {
        //Given
        GregorianCalendar calendar = new GregorianCalendar(2014, 4, 3, 8, 5, 2);
        //When
        LocalDateTime localDateTime = OldDateConversion.toLocalDateTime(calendar);

        //Then
        TemporalAccessorAssert.assertThat(localDateTime)
                .isInSameDayAs("2014-05-03")
                .isWithinHourOfDay(8)
                .isWithinMinute(5)
                .isWithinSecond(2);
    }

    @Test
    public void should_convert_LocalDateTime__to_calendar() throws ParseException {
        //Given
        LocalDateTime localDateTime = LocalDateTime.of(2014, 5, 1, 17, 5, 12);
        //When
        Calendar calendar = OldDateConversion.toCalendar(localDateTime);

        //Then
        assertThat(calendar.getTime())
                .isInSameDayAs("2014-05-01")
                .isWithinHourOfDay(17)
                .isWithinMinute(5)
                .isWithinSecond(12);
    }
}
