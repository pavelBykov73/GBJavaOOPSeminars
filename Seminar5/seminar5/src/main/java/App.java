import model.Bank;
import model.Client;
import model.Person;
import service.BankService;
import view.ClientView;
import view.Console;
import view.PersonView;

import java.time.LocalDate;

public class App {
    static BankService bankService = new BankService(new Bank("First bank"));
    static ClientView clientView = new ClientView();

    public static void main(String[] args) {
        fillBankTestClient();
        startMenu();
//        bankService.add(PersonView.inputPerson());
//        clientView.print(bankService.getAll());
//
//        bankService.delete(bankService.getAll().get(2));
//        System.out.println("After delete:");
//        clientView.print(bankService.getAll());
    }

    public static void startMenu() {
        StringBuilder sb = new StringBuilder()
                .append("\n == ")
                .append("Bank: ")
                .append(bankService.toString())
                .append(" == \n")
                .append("1 - view all clients\n")
                .append("2 - add new client\n")
                .append("3 - Operation with client\n")
                .append("0 - exit\n");

        while (true) {
            int ret = Console.inputInteger(sb.toString());
            switch (ret) {
                case 1:
                    clientView.print(bankService.getAll());
                    break;
                case 2:
                    bankService.add(PersonView.inputPerson());
                    break;
                case 3:
                    clientMenu();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void clientMenu() {
        clientView.print(bankService.getAll());
        int clientIdx = Console.inputIntegerLimit("input client number:", 0, bankService.getAll().size() - 1);
        StringBuilder menuString = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - deposit operation\n")
                .append("2 - delete client\n")
                .append("0 - exit\n");

        while (true) {
            System.out.println(bankService.getAll().get(clientIdx).toString());
            int ret = Console.inputInteger(menuString.toString());
            switch (ret) {
                case 1:
                    depositChange(bankService.getAll().get(clientIdx));
                    break;
                case 2:
                    bankService.delete(bankService.getAll().get(clientIdx));
                    return;
                case 0:
                    return;
            }
        }
    }

    private static void depositChange(Client client) {
        int value = Console.inputInteger("Введите сумму операции:");
        if (client.pushDeposit(value)) {
            System.out.println("Операция успешна!");
        } else {
            System.out.println("Средств недостаточно! Операция провалена!");
        }
    }

    public static void fillBankTestClient() {
        bankService.create("Name 1", "family 1", LocalDate.of(2000, 10, 22));
        bankService.create("Name 2", "family 2", LocalDate.of(2000, 10, 22));
        bankService.create("Name 3", "family 3", LocalDate.of(2000, 10, 22));
        bankService.create("Name 3", "family 3", LocalDate.of(2000, 10, 22));
        bankService.add(new Person("Name 3", "family 5", LocalDate.of(2000, 10, 22)));
        bankService.add(new Person("Name 3", "family 4", LocalDate.of(2000, 10, 22)));
    }


}
