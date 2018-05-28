import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Payment {

  private int paymentNumber; //imoku skaicius
  private Date paymentDate; //mokejimo data
  private BigDecimal remainingAmount; // likusi moketi kredito suma
  private BigDecimal principalPayment; //paskolos dalies imoka
  private BigDecimal interestPayment; //palukanu imoka
  private BigDecimal annuityPayment; //viena (menesine) imoka

  private Credit credit;

  public Payment(int paymentNumber, Date paymentDate, BigDecimal principalPayment, BigDecimal interestPayment, BigDecimal annuityPayment) {
    this.paymentNumber = paymentNumber;
    this.paymentDate = paymentDate;
    this.principalPayment = principalPayment;
    this.interestPayment = interestPayment;
    this.annuityPayment = annuityPayment;
  }


  public int getPaymentNumber() {
    return paymentNumber;
  }

  public void setPaymentNumber(int paymentNumber) {
    this.paymentNumber = paymentNumber;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public String getPaymentDateAsStr() {
    return DateUtils.dateToString(paymentDate);
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public BigDecimal getRemainingAmount() {
    return remainingAmount;
  }

  public String getRemainingAmountAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getRemainingAmount());
  }

  public void setRemainingAmount(BigDecimal remainingAmount) {
    this.remainingAmount = remainingAmount;
  }

  public BigDecimal getPrincipalPayment() {
    return principalPayment;
  }

  public String getPrincipalPaymentAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getPrincipalPayment());
  }

  public void setPrincipalPayment(BigDecimal principalPayment) {
    this.principalPayment = principalPayment;
  }

  public BigDecimal getInterestPayment() {
    return interestPayment;
  }

  public String getInterestPaymentAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getInterestPayment());
  }

  public void setInterestPayment(BigDecimal ineterestPayment) {
    this.interestPayment = ineterestPayment;
  }

  public BigDecimal getAnnuityPayment() {
    return annuityPayment;
  }

  public String getAnnuityPaymentAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getAnnuityPayment());
  }

  public void setAnnuityPayment(BigDecimal annuityPayment) {
    this.annuityPayment = annuityPayment;
  }

  public Credit getCredit() {
    return credit;
  }

  public void setCredit(Credit credit) {
    this.credit = credit;
  }

  public BigDecimal getCreditInterestRate() {
    return credit.getInterestRate();
  }

  public String getCreditInterestRateAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getCreditInterestRate());
  }

  public BigDecimal getCreditRemainingAmount() {
    return credit.getRemainingAmount();
  }

  public String getCreditRemainingAmountAsStr() {
    return BigDecimalUtils.bigDecimalValueAsString(this.getCreditRemainingAmount());
  }

}
