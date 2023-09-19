package ru.markina.student.app.domain;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Абстрактный класс с полями name и birthDate
 * Родитель для классов Student, Employee, Teacher
 */
public abstract class Person {

    protected final String name;
    protected final LocalDate birthDate;

    public Person(final String name, final LocalDate birthDate) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(birthDate);
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    /**
     * Метод получения возраста человека
     * @return возраст в годах
     */
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
