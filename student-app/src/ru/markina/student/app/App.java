package ru.markina.student.app;

import ru.markina.student.app.controllers.AccountController;
import ru.markina.student.app.domain.Person;
import ru.markina.student.app.domain.PersonComparators;
import ru.markina.student.app.domain.StudentStream;
import ru.markina.student.app.domain.Teacher;
import ru.markina.student.app.domain.id.IdProducer;
import ru.markina.student.app.domain.student.Student;
import ru.markina.student.app.domain.student.group.StudentGroup;
import ru.markina.student.app.domain.student.group.StudentGroupComparableFactory;
import ru.markina.student.app.services.EmployeeService;
import ru.markina.student.app.services.TeacherService;

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

        //-------------------------------------------------------------------

        var s1 = new Student("Семен", LocalDate.of(1996, 5, 19), studentsIdProducer);
        var s2 = new Student("Алла", LocalDate.of(1996, 5, 19), studentsIdProducer);

        //Сравнение студентов по дате рождения
        System.out.println(PersonComparators.personComparator(Person::getAge).compare(s2, s1));

        var teacherService = new TeacherService();
        teacherService.create("Галина", LocalDate.of(1965, 8, 17), Teacher.AcademicDegree.CANDIDATE);
        teacherService.create("Алла", LocalDate.of(1985, 1, 2));
        teacherService.create("Сергей", LocalDate.of(1958, 3, 27), Teacher.AcademicDegree.DOCTOR);
        teacherService.create("Михаил", LocalDate.of(1975, 12, 30));
        teacherService.create("Нина", LocalDate.of(1991, 4, 12), Teacher.AcademicDegree.CANDIDATE);

        //Сортировка учителей по возрасту и по имени
        System.out.println("Список учителей, отсортированный по имени:");
        teacherService.showOrdered(PersonComparators.personByNameComparator(), System.out::println);

        System.out.println("Список учителей, отсортированный по возрасту:");
        teacherService.showOrdered(PersonComparators.personComparator(Teacher::getAge), System.out::println);


        var employeeService = new EmployeeService("стажер");
        employeeService.create("Степан", LocalDate.of(1993, 4, 4));
        employeeService.create("Светлана", LocalDate.of(1980, 2, 11));
        employeeService.create("Григорий", LocalDate.of(1997, 12, 29));
        employeeService.create("Александр", LocalDate.of(2000, 11, 28));

        // Сортировка сотрудников по имени
        System.out.printf("Список отсортированных по имени сотрудников: \n%s\n",employeeService.getOrderedByName());

        // Расчет среднего возраста студентов, учителей и сотрудников
        System.out.printf("Средний возраст студентов - %.2f лет.\n", AccountController.averageAge(studentGroup5123.getStudentGroup()));
        System.out.printf("Средний возраст учителей - %.2f лет.\n", AccountController.averageAge(teacherService.getAll()));
        System.out.printf("Средний возраст сотрудников - %.2f лет.\n", AccountController.averageAge(employeeService.getAll()));

    }
}
