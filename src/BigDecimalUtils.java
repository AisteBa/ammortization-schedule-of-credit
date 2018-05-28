import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class BigDecimalUtils {

  public static String bigDecimalValueAsString(BigDecimal input) {
    final NumberFormat numberFormat = new DecimalFormat("#0.##");
    numberFormat.setGroupingUsed(true);
    numberFormat.setMaximumFractionDigits(2);
    numberFormat.setMinimumFractionDigits(2);
    return numberFormat.format(input);
  }

}
