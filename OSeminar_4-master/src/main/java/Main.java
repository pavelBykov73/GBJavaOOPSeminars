import ru.gb.oseminar.controller.StudentController;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.TeacherService;
import ru.gb.oseminar.view.TeacherView;

import java.time.LocalDate;

/**
 * Создать класс УчительСервис и реализовать аналогично проделанному на семинаре
 * Создать класс УчительВью и реализовать аналогично проделанному на семинаре
 */
public class Main {
    public static void main(String[] args) {
        // test of StudentController
        StudentController studentController = new StudentController();
        studentController.create("Name1", "Family1",
                "fff", LocalDate.of(2000, 10, 01));
        studentController.create("Name2", "Family2",
                "ggg", LocalDate.of(2004, 1, 10));
        studentController.create("Name3", "Family3",
                "hhh", LocalDate.of(2010, 3, 15));

        // test of TeacherService
        TeacherService teacherService = new TeacherService();
        teacherService.create("Teacher1Name", "Teacher1Family",
                "aaa", LocalDate.of(1983, 02, 10));
        teacherService.create("Teacher2Name", "Teacher2Family",
                "bbb", LocalDate.of(1977, 03, 11));

        TeacherView teacherView = new TeacherView();
        teacherView.sendOnConsole(teacherService.getAll());
    }
}
