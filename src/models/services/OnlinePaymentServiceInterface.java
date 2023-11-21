package models.services;

public interface OnlinePaymentServiceInterface {
  Double paymentFee(Double amount);

  Double interest(Double amount, Integer months);
}
