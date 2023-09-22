package ru.markina.mvc.student.app.model.core;

import ru.markina.mvc.student.app.model.core.id.IdProducer;

import java.time.LocalDate;

public class Student extends Person {

    private final int id;

    public Student(String name, LocalDate birthDate, IdProducer<Integer> idProducer) {
        super(name, birthDate);
        this.id = idProducer.nextId();
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Студент под номером " + id +
                ": Имя = " + name +
                ", Дата рождения = " + birthDate;
    }
}
