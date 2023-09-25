package ru.markina.mvc.student.app.controller.interfaces;

import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;

public interface GetModel {
    List<Student> students();

    /**
     * Дополнительный метод для удаления студента
     * @param id - id студента
     * @return студент
     */
    Student deleteStudent(Long id);
}
