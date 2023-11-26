package models.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Contract {
  private Integer number;
  private LocalDateTime date;
  private Double totalValue;
  private List<Installment> installments = new ArrayList<>();

  public Contract() {
  }

  public Contract(Integer number, LocalDateTime date, Double totalValue) {
    this.number = number;
    this.date = date;
    this.totalValue = totalValue;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Double getTotalValue() {
    return totalValue;
  }

  public void setTotalValue(Double totalValue) {
    this.totalValue = totalValue;
  }

  public List<Installment> getInstallments() {
    return installments;
  }

  public Double getInstallmentsValue() {
    return installments.stream().map(i -> i.getAmount()).reduce(0.0, (a, b) -> a + b);
  }
}
