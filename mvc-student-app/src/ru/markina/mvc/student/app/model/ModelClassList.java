package ru.markina.mvc.student.app.model;

import ru.markina.mvc.student.app.controller.interfaces.GetModel;
import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;

public record ModelClassList(List<Student> students) implements GetModel {

    @Override
    public Student deleteStudent(final Long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                System.out.printf("Студент под номером %d удален.\n", id);
                return students.remove(i);
            }
        }
        System.out.println("Студента с таким id нет.");
        return null;
    }
}
