package ru.gb.oseminar.data;

import java.time.LocalDate;

public class PersonNumerable extends Person implements INumerate {
    INumerate id; // interface Принцип инверсии зависимостей (DIP) чтобы различные модули были автономными и соединялись друг с другом с помощью абстракции.

    public PersonNumerable(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, INumerate id) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonNumerable)) {
            return false;
        }

        PersonNumerable user = (PersonNumerable) o;

        if (getFirstName() != null ? !getFirstName().equals(user.getFirstName()) :
                user.getFirstName() != null) {
            return false;
        }
        if (getSecondName() != null ? !getSecondName().equals(user.getSecondName()) :
                user.getSecondName() != null) {
            return false;
        }
        if (getPatronymic() != null ? !getPatronymic().equals(user.getPatronymic()) :
                user.getPatronymic() != null) {
            return false;
        }
        return getDateOfBirth() != null ? getDateOfBirth().equals(user.getDateOfBirth()) :
                user.getDateOfBirth() == null;
    }

    @Override
    public Long get() {
        return id.get();
    }

    @Override
    public void set(Long id) {
        this.id.set(id);
    }
}
