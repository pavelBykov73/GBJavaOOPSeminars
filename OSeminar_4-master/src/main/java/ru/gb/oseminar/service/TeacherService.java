package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements UserService<Teacher>{
    private List<Teacher> teacherList;
    @Override
    public List<Teacher> getAll() {
        return teacherList;
    }

    public TeacherService() {
        this.teacherList = new ArrayList<>();
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Teacher teacher: teacherList){
            if (teacher.getTeacherId() > countMaxId){
                countMaxId = teacher.getTeacherId();
            }
        }
        countMaxId++;
        Teacher teacher = new Teacher(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        teacherList.add(teacher);
    }
}
