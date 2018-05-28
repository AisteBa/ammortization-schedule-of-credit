import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

  public  static void main (String[] args) throws IOException {

    String csvFile = "C:\\tmp\\credit.csv";
    FileWriter writer = new FileWriter(csvFile);

    List<Payment> payments = AmmortizationSchedule.createAmmortizationSchedule();

    CSVUtils.writeLine(writer, Arrays.asList("Payment Number", "Payment date", "Remaining amount", "Principal payment", "Interest payment", "Annuity payment", "Interest rate"));
    CSVUtils.writePayments(writer, payments);

    AmmortizationSchedule.printAmmortizationSchedule(payments);

    writer.flush();
    writer.close();

  }
}
