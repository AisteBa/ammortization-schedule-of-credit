import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmmortizationSchedule {

  public static Credit createNewCredit() {
    Credit myCredit = new Credit(BigDecimal.valueOf(5000), BigDecimal.valueOf(12), 24,
        DateUtils.fromString("2017-04-15"));
    return myCredit;
  }

  public static List<Payment> createAmmortizationSchedule() {
    Credit myCredit = createNewCredit();

    for (int i = 1; i <= myCredit.getPaymentNumber(); i++) {
      myCredit.addPayment(new Payment(
          i,
          PaymentUtils.countPaymentDate(i, myCredit.getPaymentDate()),
          PaymentUtils.countPrincipalPayment(myCredit.getInterestRate(), myCredit.getPaymentNumber(), myCredit.getTotalCreditAmount(), myCredit.getRemainingAmount()),
          PaymentUtils.countInterestPayment(myCredit.getRemainingAmount(), myCredit.getInterestRate()),
          PaymentUtils.countAnnuityPayment(myCredit.getInterestRate(), myCredit.getPaymentNumber(), myCredit.getTotalCreditAmount())
      ));

    }

    return myCredit.getPayments();
  }

  public static void printAmmortizationSchedule(List<Payment> payments) {

    for (int i = 0; i < payments.size(); i++) {
      System.out.print(" Imokos numeris: " + payments.get(i).getPaymentNumber());
      System.out.print(" Imokos data: " + payments.get(i).getPaymentDateAsStr());
      System.out.println(" Likusi kredito suma " + payments.get(i).getRemainingAmountAsStr());
      System.out.print(" Paskolos grazinama: " + payments.get(i).getPrincipalPaymentAsStr());
      System.out.print(" Palukanu prsikaiciuota imokai: " + payments.get(i).getInterestPaymentAsStr());
      System.out.print(" Menesine anuitetine imoka: " + payments.get(i).getAnnuityPaymentAsStr());
      System.out.print(" Metine palukanu norma: " + payments.get(i).getCreditInterestRate());
      System.out.println();
      System.out.println("=========================================================================");
    }
  }
}
