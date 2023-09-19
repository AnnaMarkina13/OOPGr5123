package ru.markina.student.app;

import ru.markina.student.app.domain.StudentStream;
import ru.markina.student.app.domain.id.IdProducer;
import ru.markina.student.app.domain.student.Student;
import ru.markina.student.app.domain.student.group.StudentGroup;
import ru.markina.student.app.domain.student.group.StudentGroupComparableFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Создание объекта для определения id студентов
        IdProducer<Integer> studentsIdProducer = IdProducer.ofInt();

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("Иван", LocalDate.of(1997, 7, 13), studentsIdProducer),
                new Student("Игорь", LocalDate.of(1997, 10, 25), studentsIdProducer),
                new Student("Иван", LocalDate.of(1997, 3, 3), studentsIdProducer),
                new Student("Игорь", LocalDate.of(1997, 4, 18), studentsIdProducer),
                new Student("Даша", LocalDate.of(1997, 1, 23), studentsIdProducer),
                new Student("Лена", LocalDate.of(1997, 11, 5), studentsIdProducer)
        ));

        //Создание группы студентов и объекта для определения id группы
        IdProducer<Integer> groupIdProducer = IdProducer.ofInt(5123);
        var studentGroup5123 = new StudentGroup(students, groupIdProducer);

        studentGroup5123.forEach(System.out::println);

        Collections.sort(studentGroup5123.getStudentGroup());
        System.out.printf("\nОтсортированный список студентов группы №%d по возрасту (дате рождения):\n", studentGroup5123.getGroupId());
        studentGroup5123.forEach(System.out::println);


        List<Student> students1 = new ArrayList<>(Arrays.asList(
                new Student("Илья", LocalDate.of(1996, 5, 19), studentsIdProducer),
                new Student("Евгения", LocalDate.of(1997, 12, 31), studentsIdProducer),
                new Student("Оксана", LocalDate.of(1996, 2, 1), studentsIdProducer),
                new Student("Дмитрий", LocalDate.of(1998, 3, 14), studentsIdProducer)
        ));

        var studentGroup5124 = new StudentGroup(students1, groupIdProducer);

        List<Student> students2 = new ArrayList<>(Arrays.asList(
                new Student("Семен", LocalDate.of(1996, 5, 19), studentsIdProducer),
                new Student("Анна", LocalDate.of(1997, 12, 31), studentsIdProducer),
                new Student("Ева", LocalDate.of(1996, 2, 1), studentsIdProducer),
                new Student("Игнат", LocalDate.of(1998, 3, 14), studentsIdProducer),
                new Student("Захар", LocalDate.of(1997, 9, 22), studentsIdProducer)
        ));

        var studentGroup5125 = new StudentGroup(students2, groupIdProducer);

        //Создание объекта для определения номера потока и самого потока
        IdProducer<Integer> studentStreamId = IdProducer.ofInt();

        StudentStream studentStream = new StudentStream(
                new ArrayList<>(Arrays.asList(studentGroup5123, studentGroup5124, studentGroup5125)
                ), studentStreamId
        );

        System.out.printf("\nГруппы в потоке №%d: \n", studentStream.getStudentStreamId());
        studentStream.forEach(System.out::println);

        System.out.println("\nОтсортированные группы по количеству учеников: ");
        studentStream.getStudentGroups().stream()
                .map(StudentGroupComparableFactory::bySize)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nОтсортированные группы по идентификатору группы: ");
        studentStream.getStudentGroups().stream()
                .map(StudentGroupComparableFactory::byId)
                .sorted()
                .forEach(System.out::println);
    }
}
