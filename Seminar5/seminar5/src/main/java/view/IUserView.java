package view;

import model.Person;

import java.util.List;

public interface IUserView<T extends Person> {
    void print(List<T> list);

//    T inputFromUser();
}
