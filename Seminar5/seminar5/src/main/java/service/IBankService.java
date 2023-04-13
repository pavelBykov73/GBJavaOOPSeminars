package service;

import model.Client;
import model.Person;

import java.time.LocalDate;
import java.util.List;

public interface IBankService {
    List<Client> getAll();

    boolean create(String firstName, String lastName, LocalDate dateOfBirth);

    boolean delete(Client client);

    boolean add(Person person);
}
