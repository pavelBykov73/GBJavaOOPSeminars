package ru.gb.oseminar.data;

import java.time.LocalDate;

public interface IPerson {
    String getFirstName();

    void setFirstName(String firstName);

    String getSecondName();

    void setSecondName(String secondName);

    String getPatronymic();

    void setPatronymic(String patronymic);

    LocalDate getDateOfBirth();

    void setDateOfBirth(LocalDate dateOfBirth);
}

