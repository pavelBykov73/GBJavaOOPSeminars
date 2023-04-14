package service;

import model.Bank;
import model.Client;
import model.Person;
import view.BankView;
import view.ClientView;

import java.time.LocalDate;
import java.util.List;

public class BankService implements IBankService {
    private Bank bank;
    private BankView bankView;

    public BankService(Bank bank) {
        this.bank = bank;
        this.bankView = new BankView(bank);
    }

    @Override
    public List<Client> getAll() {
        return bank.getClients();
    }

    public void setClients(List<Client> clients) {
        bank.setClients(clients);
    }

    private Long getClientMaxId() {
        Long countMaxId = 0L;
        for (Client client : bank.getClients()) {
            if (client.getId() > countMaxId) {
                countMaxId = client.getId();
            }
        }
        return countMaxId;
    }

    private boolean checkExist(Person person) {
        for (Client client : bank.getClients()) {
            if ((person.equals((Person) client))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(String firstName, String lastName, LocalDate dateOfBirth) {
        Person person = new Person(firstName, lastName, dateOfBirth);
        return add(person);
    }

    @Override
    public boolean delete(Client o) {
        for (Client client : bank.getClients()) {
            if (client.equals(o)) {
                bank.getClients().remove(client);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Person person) {
        if (!checkExist(person)) {
            Client client = new Client(person.getFirstName(), person.getLastName(),
                    person.getDateOfBirth(), getClientMaxId() + 1);
            bank.getClients().add(client);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return bank.toString();
    }

    public Client selectClient() {
        bankView.print(bank.getClients());
        return bankView.selectClient(bank.getClients());
    }

    public void showAllClients() {
        bankView.print(bank.getClients());
    }

    public int getOperation() {
        return bankView.getOperation();
    }
}