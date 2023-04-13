package service;

import model.Bank;
import model.Client;
import model.Person;

import java.time.LocalDate;
import java.util.List;

public class BankService implements IBankService {
    private Bank bank;

    public BankService(Bank bank) {
        this.bank = bank;
    }

    @Override
    public List<Client> getAll() {
        return bank.getClients();
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

    @Override
    public void create(String firstName, String lastName, LocalDate dateOfBirth) {
        Client client = new Client(firstName, lastName, dateOfBirth, getClientMaxId() + 1);
        bank.getClients().add(client);
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
//        Client newClient = new Client()
//        if (!bank.getClients().contains(o)) {
//            create(o.getFirstName(), o.getLastName(), o.getDateOfBirth()); // bank.getClients().add(o);
//            return true;
//        }
        return false;
    }
}
