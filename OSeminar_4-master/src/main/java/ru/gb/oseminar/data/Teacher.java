package ru.gb.oseminar.data;

import java.time.LocalDate;
import java.util.Comparator;

public class Teacher extends PersonNumerable {

    public Teacher(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, Long id) {
        super(firstName, secondName, patronymic, dateOfBirth, new Id(id));
    }

    public Long getTeacherId() {
        return id.get();
    }

    public void setTeacherId(Long teacherId) {
        id.set(teacherId);
    }

    public static class TeacherComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    }

    public String toString() {
        return "Teacher{" +
                "Id='" + id.get() + '\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", patronymic='" + super.getPatronymic() + '\'' +
                ", dateOfBirth=" + super.getDateOfBirth() +
                '}';
    }
}
