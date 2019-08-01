import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimePeriodTest {
    private SimpleDateFormat simpleDateFormat;
    private TimePeriod timePeriodA;
    private TimePeriod timePeriodB;

    @Before
    public void setup() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date dateAStart = simpleDateFormat.parse("2018-02-02");
        Date dateAEnd = simpleDateFormat.parse("2018-12-12");
        timePeriodA = new TimePeriod(dateAStart, dateAEnd);
    }

    @Test
    public void dateAContainsDateB() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-03-02");
        Date dateBEnd = simpleDateFormat.parse("2018-09-02");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void dateBContainsDateA() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-03-02");
        Date dateBEnd = simpleDateFormat.parse("2018-09-02");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodB.overlapsWith(timePeriodA));
    }

    @Test
    public void dateBInteractA() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-01-02");
        Date dateBEnd = simpleDateFormat.parse("2018-09-02");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void dateAInteractB() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-04-02");
        Date dateBEnd = simpleDateFormat.parse("2018-12-22");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void dateAEqualsB() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-02-02");
        Date dateBEnd = simpleDateFormat.parse("2018-12-12");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void dateAEndEqualToBStart() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-12-12");
        Date dateBEnd = simpleDateFormat.parse("2018-12-22");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertTrue(timePeriodA.overlapsWith(timePeriodB));
    }

    @Test
    public void dateANotOverlappingB() throws ParseException {
        Date dateBStart = simpleDateFormat.parse("2018-12-22");
        Date dateBEnd = simpleDateFormat.parse("2018-12-24");
        timePeriodB = new TimePeriod(dateBStart, dateBEnd);

        assertFalse(timePeriodA.overlapsWith(timePeriodB));
    }
}