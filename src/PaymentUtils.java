import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class PaymentUtils {

  public static Date countPaymentDate(int paymentNumber, Date firstPaymentDate){
    return paymentNumber == 1 ? firstPaymentDate : DateUtils.addMonth(firstPaymentDate, paymentNumber-1);
  }


  public static BigDecimal countPrincipalPayment(BigDecimal interestRate, int paymentNumber,
      BigDecimal totalCreditAmount, BigDecimal remainingAmount){
    BigDecimal annuityPayment = countAnnuityPayment(interestRate, paymentNumber, totalCreditAmount);
    BigDecimal interestPayment = countInterestPayment(remainingAmount, interestRate);
    return annuityPayment.subtract(interestPayment);
  }

  public static BigDecimal countInterestPayment(BigDecimal remainingAmount, BigDecimal interestRate) {
    BigDecimal interestRateMonthly = interestRate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_DOWN);
    BigDecimal interestRatePerMonth = interestRateMonthly.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_DOWN);
    return remainingAmount.multiply(interestRatePerMonth);
  }

  public static BigDecimal countAnnuityPayment(BigDecimal interestRate, int paymentNumber,
      BigDecimal totalCreditAmount) {
    BigDecimal interestRatePerMonth = countInterestRatePerMonth(interestRate);
    BigDecimal ratePlusOne = BigDecimal.valueOf(1).add(interestRatePerMonth);
    BigDecimal powOfRatePlusOne = ratePlusOne.pow(paymentNumber);
    BigDecimal divider = powOfRatePlusOne.subtract(BigDecimal.valueOf(1));
    BigDecimal coefficient = (interestRatePerMonth.multiply(powOfRatePlusOne)).divide(divider, 10, RoundingMode.HALF_DOWN);
    BigDecimal annuityPayment = totalCreditAmount.multiply(coefficient);
    return annuityPayment;
  }

  public static BigDecimal countInterestRatePerMonth(BigDecimal interestRate) {
    return interestRate.divide(BigDecimal.valueOf(12), 10, RoundingMode.HALF_DOWN)
        .divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_DOWN);
  }

}
