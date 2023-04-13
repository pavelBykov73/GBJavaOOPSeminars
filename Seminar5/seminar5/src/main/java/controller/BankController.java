package controller;

import model.Bank;
import model.Client;
import model.Person;
import service.BankService;
import view.ClientView;
import view.Console;
import view.PersonView;

import java.time.LocalDate;
import java.util.List;

public class BankController implements IBankController {
    BankService bankService;
    ClientView clientView;

    public BankController() {
        bankService = new BankService(new Bank("First bank"));
        clientView = new ClientView();
    }

    public void fillBankTestClient() {
        bankService.create("Name 1", "family 1", LocalDate.of(2000, 10, 22));
        bankService.create("Name 2", "family 2", LocalDate.of(2000, 10, 22));
        bankService.create("Name 3", "family 3", LocalDate.of(2000, 10, 22));
        bankService.create("Name 3", "family 3", LocalDate.of(2000, 10, 22));
        bankService.add(new Person("Name 3", "family 5", LocalDate.of(2000, 10, 22)));
        bankService.add(new Person("Name 3", "family 4", LocalDate.of(2000, 10, 22)));
    }

    @Override
    public void init() {
        // TODO load from database or file
    }

    @Override
    public void exit() {
        // TODO store to database or file
    }

    @Override
    public List<Client> getClients() {
        return bankService.getAll();
    }

    @Override
    public boolean addClient(Person person) {
        return bankService.add(person);
    }

    @Override
    public boolean deleteClient(Client client) {
        return bankService.delete(client);
    }

    @Override
    public Client getClient(int index) {
        if (index < bankService.getAll().size()) {
            return bankService.getAll().get(index);
        }
        return null;
    }

    @Override
    public void mainMenu() {
        StringBuilder sb = new StringBuilder()
                .append("\n == ")
                .append(bankService.toString())
                .append(" == \n")
                .append("1 - view all clients\n")
                .append("2 - add new client\n")
                .append("3 - Operation with client\n")
                .append("0 - exit\n");

        while (true) {
            //int ret = BankView.getAction();
            int ret = Console.inputInteger(sb.toString());
            switch (ret) {
                case 1:
                    clientView.print(getClients());
                    break;
                case 2:
                    addClient(PersonView.inputPerson());
                    break;
                case 3:
                    clientMenu();
                    break;
                case 0:
                    return;
            }
        }
    }

    private void clientMenu() {
        clientView.print(getClients());
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
                    //depositChange(getClient(clientIdx));
                    break;
                case 2:
                    deleteClient(getClient(clientIdx));
                    return;
                case 0:
                    return;
            }
        }
    }
}
