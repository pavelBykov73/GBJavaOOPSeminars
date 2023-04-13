package model;

import java.util.ArrayList;
import java.util.List;

public class Bank implements Iterable<Client> {
    private List<Client> clients = new ArrayList<>();
    private String name;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Client> getClients() {
        return clients;
    }


    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public ClientsOfBankIterator iterator() {
        return new ClientsOfBankIterator(this);
    }
}
