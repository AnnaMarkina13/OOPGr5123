package ru.markina.mvc.student.app.controller.interfaces;

import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;
import java.util.Scanner;

public interface GetView {
    void printStudents(List<Student> students);

    default String prompt(final String message) {
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }
}
