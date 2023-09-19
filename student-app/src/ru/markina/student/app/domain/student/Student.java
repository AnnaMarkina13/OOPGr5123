package ru.markina.student.app.domain.student;

import ru.markina.student.app.domain.Person;
import ru.markina.student.app.domain.id.IdProducer;

import java.time.LocalDate;

public class Student extends Person implements Comparable<Student> {

    private final int id;

    public Student(String name, LocalDate birthDate, IdProducer<Integer> idProducer) {
        super(name, birthDate);
        this.id = idProducer.nextId();
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Студент под номером " + id +
                ": Имя = " + name +
                ", Дата рождения = " + birthDate;
    }

    @Override
    public int compareTo(final Student anotherStudent) {
        return birthDate.compareTo(anotherStudent.birthDate);
    }
}
