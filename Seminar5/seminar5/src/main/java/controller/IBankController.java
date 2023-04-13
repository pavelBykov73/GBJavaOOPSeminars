package controller;

import model.Client;
import model.Person;

import java.util.List;

public interface IBankController {
    void init();

    void exit();

    List<Client> getClients();

    boolean addClient(Person person);

    boolean deleteClient(Client client);

    Client getClient(int index);

    void mainMenu();
}
