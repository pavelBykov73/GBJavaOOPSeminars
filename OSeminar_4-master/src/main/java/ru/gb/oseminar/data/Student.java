package ru.gb.oseminar.data;

import java.time.LocalDate;

public class Student extends PersonNumerable implements Comparable<Student> {

    public Student(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, Long studentId) {
        super(firstName, secondName, patronymic, dateOfBirth, new Id(studentId));
    }

    public Long getStudentId() {
        return id.get();
    }

    public void setStudentId(Long studentId) {
        id.set(studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + id.get() + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", patronymic='" + super.getPatronymic() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.id.get().compareTo(o.id.get());
    }
}
