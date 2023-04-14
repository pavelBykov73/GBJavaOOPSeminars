package controller;

import model.Bank;
import model.Client;
import model.Person;
import service.BankService;
import service.ClientService;
import service.DataProvider;
import view.PersonView;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankController implements IBankController {
    BankService bankService;
    DataProvider dataProvider;

    public BankController() {
        bankService = new BankService(new Bank("First bank"));
        dataProvider = new DataProvider("clients.dat");
        init();
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
        List<Client> clients = dataProvider.restore();
        if (clients != null) {
            bankService.setClients(clients);
            System.out.println("База клиентов загружена.");
        } else {
            System.out.println("Ошибка загрузки базы клиентов.");
        }
    }

    @Override
    public void exit() {
        if (dataProvider.store(bankService.getAll())) {
            System.out.println("База клиентов сохранена");
        } else {
            System.out.println("Ошибка записи базы клиентов.");
        }
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
                    exit();
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
