package model;

import java.util.Iterator;
import java.util.List;

public class ClientsOfBankIterator implements Iterator<Client> {

    private int counter;
    private final List<Client> clients;

    public ClientsOfBankIterator(Bank bank) {
        this.clients = bank.getClients();
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < clients.size() - 1;
    }

    @Override
    public Client next() {
        if (!hasNext()) {
            return null;
        }
        counter++;
        return clients.get(counter);
    }
}
