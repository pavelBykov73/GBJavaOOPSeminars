package view;

import model.Client;
import model.Person;

import java.time.LocalDate;

import static view.Console.inputDate;

public class PersonView {
    public static Person inputFromUser() {
        String firstName = Console.inputString("Input first name:");
        String lastName = Console.inputString("Input last name:");
        LocalDate birthDate = inputDate("Введите дату рождения:");
        return new Person(firstName, lastName, birthDate);
    }

}
