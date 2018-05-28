import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

  private static final char DEFAULT_SEPARATOR = ';';

  public static void writePayments(Writer w, List<Payment> values) throws IOException {
    for(Payment payment : values){
      writePayment(w, payment);
    }
  }

  public static void writePayment(Writer w, Payment payment) throws IOException {
    writeLine(w, paymentToCsvValues(payment), DEFAULT_SEPARATOR, ' ');
  }

  public static List<String> paymentToCsvValues(Payment payment){
    List<String> values = new ArrayList<>();
    values.add(String.valueOf(payment.getPaymentNumber()));
    values.add(String.valueOf(payment.getPaymentDateAsStr()));
    values.add(String.valueOf(payment.getRemainingAmountAsStr()));
    values.add(String.valueOf(payment.getPrincipalPaymentAsStr()));
    values.add(String.valueOf(payment.getInterestPaymentAsStr()));
    values.add(String.valueOf(payment.getAnnuityPaymentAsStr()));
    values.add(String.valueOf(payment.getCreditInterestRate()));
    return values;
  }

  public static void writeLine(Writer w, List<String> values) throws IOException {
    writeLine(w, values, DEFAULT_SEPARATOR, ' ');
  }

  public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
    writeLine(w, values, separators, ' ');
  }

  private static String followCVSformat(String value) {

    String result = value;
    if (result.contains("\"")) {
      result = result.replace("\"", "\"\"");
    }
    return result;

  }

  public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

    boolean first = true;

    //default customQuote is empty

    if (separators == ' ') {
      separators = DEFAULT_SEPARATOR;
    }

    StringBuilder sb = new StringBuilder();
    for (String value : values) {
      if (!first) {
        sb.append(separators);
      }
      if (customQuote == ' ') {
        sb.append(followCVSformat(value));
      } else {
        sb.append(customQuote).append(followCVSformat(value)).append(customQuote);
      }

      first = false;
    }
    sb.append("\n");
    w.append(sb.toString());


  }

}
