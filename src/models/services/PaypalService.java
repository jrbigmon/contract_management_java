package models.services;

public class PaypalService implements OnlinePaymentServiceInterface {
  private Double interestPercentage;
  private Double feePercentage;

  public PaypalService(Double interestPercentage, Double feePercentage) {
    this.interestPercentage = interestPercentage;
    this.feePercentage = feePercentage;
  }

  // juros
  public Double interest(Double amount, Integer month) {
    return amount + (amount * interestPercentage / 100) * month;
  }

  // taxa de pagamento
  public Double paymentFee(Double amount) {
    return amount + (amount * feePercentage / 100);
  }
}
