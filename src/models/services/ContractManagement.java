package models.services;

import java.time.LocalDateTime;

import models.entities.Contract;
import models.entities.Installment;

public class ContractManagement {
  private OnlinePaymentServiceInterface paymentService;

  public ContractManagement(OnlinePaymentServiceInterface paymentService) {
    this.paymentService = paymentService;
  }

  private Double getValuePerMonth(Double amount, Integer month) {
    Double interest = paymentService.interest(amount, month);
    return paymentService.paymentFee(interest);
  }

  private LocalDateTime getInstallmentDate(LocalDateTime firstInstallment, Integer month) {
    return firstInstallment.plusMonths(month);
  }

  public void processContract(Contract contract, Integer months) {
    Double basicQuota = contract.getTotalValue() / months;

    for (Integer month = 1; month <= months; month++) {
      LocalDateTime installmentDate = getInstallmentDate(contract.getDate(), month);
      Double amount = getValuePerMonth(basicQuota, month);
      contract.getInstallments().add(new Installment(installmentDate, amount));
    }
  }
}