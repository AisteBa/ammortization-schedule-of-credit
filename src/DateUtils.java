import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

  private final static SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

  public static String dateToString(Date date) {
    return DEFAULT_DATE_FORMAT.format(date);
  }

  public static Date fromString(String dateStr) {
    try {
      return DEFAULT_DATE_FORMAT.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Date addDay(Date date, int i) {
    return addComponent(date, Calendar.DAY_OF_YEAR, i);
  }

  public static Date addMonth(Date date, int i) {
    return addComponent(date, Calendar.MONTH, i);
  }

  public static Date addYear(Date date, int i) {
    return addComponent(date, Calendar.YEAR, i);
  }

  public static Date addComponent(Date date, int dateComponent, int i) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.add(dateComponent, i);
    return cal.getTime();
  }


}
