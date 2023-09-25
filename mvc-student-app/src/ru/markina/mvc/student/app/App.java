package ru.markina.mvc.student.app;

import ru.markina.mvc.student.app.controller.ControllerClass;
import ru.markina.mvc.student.app.model.ModelClassHash;
import ru.markina.mvc.student.app.model.core.Student;
import ru.markina.mvc.student.app.model.core.id.IdProducer;
import ru.markina.mvc.student.app.view.ViewClassEnglish;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        var studentsIdProducer = IdProducer.ofInt();

        var students = new ArrayList<>(Arrays.asList(
                new Student("Иван", LocalDate.of(1997, 7, 13), studentsIdProducer),
                new Student("Игорь", LocalDate.of(1997, 10, 25), studentsIdProducer),
                new Student("Иван", LocalDate.of(1997, 3, 3), studentsIdProducer),
                new Student("Игорь", LocalDate.of(1997, 4, 18), studentsIdProducer),
                new Student("Даша", LocalDate.of(1997, 1, 23), studentsIdProducer),
                new Student("Лена", LocalDate.of(1997, 11, 5), studentsIdProducer)
        ));

        var controllerClass = new ControllerClass(new ModelClassHash(students), new ViewClassEnglish());
        controllerClass.run();
    }
}
