import model.Bank;
import model.Client;
import service.BankService;
import view.ClientView;
import view.PersonView;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Bank bank = new Bank("First bank");
        BankService bankService = new BankService(bank);
        bankService.create("Name 1", "family 1", LocalDate.of(2000, 10, 22));
        bankService.create("Name 2", "family 2", LocalDate.of(2000, 10, 22));
        bankService.create("Name 3", "family 3", LocalDate.of(2000, 10, 22));
        bankService.add(new Client("Name 3", "family 5", LocalDate.of(2000, 10, 22), 3L, 333));
        bankService.add(new Client("Name 3", "family 4", LocalDate.of(2000, 10, 22), 4L, 333));

        ClientView clientView = new ClientView();
        bankService.add(PersonView.inputFromUser());
        clientView.print(bankService.getAll());

        bankService.delete(bankService.getAll().get(2));
        System.out.println("After delete:");
        clientView.print(bankService.getAll());
    }
}
