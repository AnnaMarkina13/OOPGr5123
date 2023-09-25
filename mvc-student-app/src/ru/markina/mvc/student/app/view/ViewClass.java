package ru.markina.mvc.student.app.view;

import ru.markina.mvc.student.app.controller.interfaces.GetView;
import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;

public class ViewClass implements GetView {

    public void printStudents(List<Student> students) {
        System.out.println("-------------Список студентов-------------");
        students.forEach(System.out::println);
    }
}
