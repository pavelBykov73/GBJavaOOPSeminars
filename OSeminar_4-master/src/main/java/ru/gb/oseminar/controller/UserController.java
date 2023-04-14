package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Person;

import java.time.LocalDate;

public interface UserController<T extends Person> {
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}
