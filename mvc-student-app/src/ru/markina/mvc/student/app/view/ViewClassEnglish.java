package ru.markina.mvc.student.app.view;

import ru.markina.mvc.student.app.controller.interfaces.GetView;
import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;

public class ViewClassEnglish implements GetView {

    /**
     * Метод для вывода списка студентов с заголовком на английском языке
     * @param students  список студентов
     */
    @Override
    public void printStudents(final List<Student> students) {
        System.out.println("-------------List of students-------------");
        students.forEach(System.out::println);
    }
}
