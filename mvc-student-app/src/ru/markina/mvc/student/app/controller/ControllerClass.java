package ru.markina.mvc.student.app.controller;

import ru.markina.mvc.student.app.controller.interfaces.GetModel;
import ru.markina.mvc.student.app.controller.interfaces.GetView;
import ru.markina.mvc.student.app.model.core.Student;

import java.util.ArrayList;
import java.util.List;

public class ControllerClass {

    private final GetModel model;
    private final GetView viewClass;
    private List<Student> students;

    public ControllerClass(final GetModel model, final GetView viewClass) {
        students = new ArrayList<>();
        this.model = model;
        this.viewClass = viewClass;
    }

    private boolean testData(List<Student> students) {
        return !students.isEmpty();
    }

    public void update() {
        students = model.students();

        if (testData(students)) {
            viewClass.printStudents(students);
        } else {
            System.out.println("Список студентов пуст.");
        }
    }

    public void run() {
        var command = Command.NONE;
        var getNewIteration = true;
        while (getNewIteration) {
            var newCommand = viewClass.prompt("Введите команду: ");
            command = Command.valueOf(newCommand.toUpperCase());
            switch (command) {
                case EXIT -> {
                    getNewIteration = false;
                    System.out.println("Выход из программы");
                }
                case LIST -> viewClass.printStudents(model.students());
                // Добавлен кейс для удаления студента
                case DELETE -> {
                    var studentId = viewClass.prompt("Введите id студента, которого необходимо удалить: ");
                    model.deleteStudent(Long.valueOf(studentId));
                }
                default -> System.out.println("Команда не распознана.");
            }
        }
    }
}
