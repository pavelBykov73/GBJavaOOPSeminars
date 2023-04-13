package controller;

import model.Bank;
import model.Client;
import model.Person;
import service.BankService;
import service.ClientService;
import view.PersonView;

import java.time.LocalDate;
import java.util.List;

public class BankController implements IBankController {
    BankService bankService;

    public BankController() {
        bankService = new BankService(new Bank("First bank"));
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
        while (true) {
            int ret = bankService.getOperation();
            switch (ret) {
                case 1:
                    bankService.showAllClients();
                    break;
                case 2:
                    clientMenu();
                    break;
                case 3:
                    addClient(PersonView.inputPerson());
                    break;
                case 4:
                    bankService.delete(bankService.selectClient());
                    break;
                case 0:
                    return;
            }
        }
    }

    private void clientMenu() {
        ClientService clientService = new ClientService(bankService.selectClient());
        while (true) {
            clientService.getClientView().clientInfoUpdate(clientService.getClient());
            int ret = clientService.getOperationWithClient();
            switch (ret) {
                case 1:
                    clientService.depositOperation();
                    break;
                case 2:
                    break;
                case 0:
                    return;
            }
        }
    }
}
