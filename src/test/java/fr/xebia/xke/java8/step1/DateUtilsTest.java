package fr.xebia.xke.java8.step1;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static fr.xebia.xke.test.TemporalAccessorAssert.assertThat;
import static org.fest.assertions.api.Assertions.assertThat;

public class DateUtilsTest {

    @Test
    public void should_parse_date() {
        LocalDate date = DateUtils.parseDate("2014-01-27");

        assertThat(date).isInSameDayAs("2014-01-27");
    }

    @Test
    public void should_parse_date_time() {
        LocalDateTime date = DateUtils.parseDateTime("2014-01-27T12:05:10.");

        assertThat(date).isInSameDayAs("2014-01-27");
        assertThat(date).isWithinHourOfDay(12);
        assertThat(date).isWithinMinute(05);
        assertThat(date).isWithinSecond(10);
    }

    @Test
    public void should_compute_age() {
        assertThat(computeAgeFor("2013-07-08", "2014-02-06")).isEqualTo(0);
        assertThat(computeAgeFor("2010-10-12", "2014-02-06")).isEqualTo(3);
        assertThat(computeAgeFor("2010-01-28", "2014-02-06")).isEqualTo(4);
    }

    private int computeAgeFor(String birthday, String currentDate) {
        return DateUtils.age(DateUtils.parseDate(birthday), DateUtils.parseDate(currentDate));
    }

    @Test
    public void should_compute_day_with_time() {
        LocalDate day = DateUtils.parseDate("2013-07-08");
        LocalDateTime dateWithTime = DateUtils.dayDateWithTime(day, 15, 12, 3);

        assertThat(dateWithTime).isInSameDayAs("2013-07-08");
        assertThat(dateWithTime).isWithinHourOfDay(15);
        assertThat(dateWithTime).isWithinMinute(12);
        assertThat(dateWithTime).isWithinSecond(3);
    }

    @Test
    public void should_add_duration() {
        LocalDateTime date = DateUtils.addDuration(DateUtils.parseDateTime("2014-01-27T12:05:10."), 162);

        assertThat(date).isInSameDayAs("2014-01-27");
        assertThat(date).isWithinHourOfDay(14);
        assertThat(date).isWithinMinute(47);
        assertThat(date).isWithinSecond(10);
    }

    @Test
    public void should_return_true_when_days_are_equals() {
        assertThat(DateUtils.dayAreEquals("2014-01-27T12:05:10.", "2014-01-27T20:05:10.")).isTrue();
        assertThat(DateUtils.dayAreEquals("2014-01-27T12:05:10.", "2014-01-28T12:05:10.")).isFalse();
    }

    @Test
    public void should_convert_to_time_zone() {
        String date = DateUtils.convertToTimeZone("2014-01-18T12:00:00.", "Europe/Moscow", "America/New_York");

        assertThat(date).isEqualTo("2014-01-18T03:00:00.");

    }
}
