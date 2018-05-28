import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Credit {

  private BigDecimal totalCreditAmount; //kredito dydis
  private BigDecimal interestRate; // metine palukanu norma
  private int paymentNumber; //imoku skaicius
  private Date paymentDate; //mokejimo data
  private List<Payment> payments = new LinkedList<>();
  private BigDecimal remainingAmount; //likusi kredito suma

  public Credit(BigDecimal totalCreditAmount, BigDecimal interestRate, int paymentNumber,
      Date paymentDate) {
    this.totalCreditAmount = totalCreditAmount;
    this.remainingAmount = totalCreditAmount;
    this.interestRate = interestRate;
    this.paymentNumber = paymentNumber;
    this.paymentDate = paymentDate;
  }


  public BigDecimal getTotalCreditAmount() {
    return totalCreditAmount;
  }

  public void setTotalCreditAmount(BigDecimal totalCreditAmount) {
    this.totalCreditAmount = totalCreditAmount;
  }

  public BigDecimal getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(BigDecimal interestRate) {
    this.interestRate = interestRate;
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

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  public void addPayment(Payment payment) {
    payment.setCredit(this);
    this.payments.add(payment);
    this.remainingAmount = this.remainingAmount.subtract(payment.getPrincipalPayment());
    if (paymentNumber == 1){
      payment.setRemainingAmount(getTotalCreditAmount());
    } else {
      payment.setRemainingAmount(this.remainingAmount);
    }
  }

  public BigDecimal getRemainingAmount() {
    return remainingAmount;
  }

  public void setRemainingAmount(BigDecimal remainingAmount) {
    this.remainingAmount = remainingAmount;
  }
}