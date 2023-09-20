package ru.markina.student.app.services;

import ru.markina.student.app.domain.PersonComparators;
import ru.markina.student.app.domain.id.IdProducer;
import ru.markina.student.app.domain.student.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements PersonService<Student> {

    private int count;
    private final List<Student> students;

    private final IdProducer<Integer> idProducer;

    public StudentService(IdProducer<Integer> idProducer) {
        this.students = new ArrayList<>();
        this.idProducer = idProducer;
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public Student create(final String name, final LocalDate birthDate) {
        var student = new Student(name, birthDate, idProducer);
        students.add(student);
        return student;
    }

    /**
     * Метод для сортировки студентов по имени
     * @return отортированный список студентов
     */
    public List<Student> getOrderedByName() {
        students.sort(PersonComparators.personByNameComparator());
        return students;
    }

    /**
     * Метод для сортировки студентов по возрасту
     * @return отортированный список студентов
     */
    public List<Student> getOrderedByAge() {
        students.sort(PersonComparators.personComparator(Student::getAge));
        return students;
    }
}
