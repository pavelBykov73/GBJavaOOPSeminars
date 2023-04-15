package ru.gb.oseminar.service;

import ru.gb.oseminar.data.INumerate;
import ru.gb.oseminar.data.Numerator;
import ru.gb.oseminar.data.PersonNumerable;
import ru.gb.oseminar.data.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        PersonNumerable obj1 = new Student("a", "b", "c", LocalDate.of(2004, 1, 10), 0L);
        Numerator<PersonNumerable> numerator = new Numerator<>((List<PersonNumerable>) students);
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, numerator.getUniqueId());
        students.add(student);
    }
}
