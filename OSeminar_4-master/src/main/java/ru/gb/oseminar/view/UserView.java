package ru.gb.oseminar.view;

import ru.gb.oseminar.data.Person;

import java.util.List;

public interface UserView<T extends Person> {
    void sendOnConsole(List<T> list);
}
