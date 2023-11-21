import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.entities.Contract;
import models.services.ContractManagement;
import models.services.PaypalService;

public class App {
    public static void main(String[] args) throws Exception {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        Contract contract = new Contract(8028, LocalDateTime.parse("25/06/2018 10:00", fmt), 600.00);

        ContractManagement contractManagement = new ContractManagement(new PaypalService(1.00, 2.00));

        contractManagement.processContract(contract, 2);

        for (var installment : contract.getInstallments()) {
            System.out.println(installment.getDueDate() + " - " + installment.getAmount());
        }

        System.out.println(contract.getInstallmentsValue());
    }
}
