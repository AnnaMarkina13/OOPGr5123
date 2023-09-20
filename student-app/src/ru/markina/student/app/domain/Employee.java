package ru.markina.student.app.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {

    /**
     * Класс для описания работника
     * поле specialty - специальность, previousJobs - список предыдущих занимаемых должностей
     */
    private String specialty;

    private final List<String> previousJobs;

    public Employee(String name, LocalDate birthDate, String specialty) {
        super(name, birthDate);
        this.specialty = specialty;
        this.previousJobs = new ArrayList<>();
    }

    public String getSpecialty() {
        return specialty;
    }

    /**
     * Метод для увольнения сотрудника с текущей должности
     */
    public void retire() {
        if (specialty != null) {
            System.out.printf("%s увольняется со специальности \"%s\"", name, specialty);
            previousJobs.add(specialty);
            specialty = null;
        } else {
            System.out.printf("Сотрудник %s уже не работает", name);
        }
    }

    /**
     * Метод для назначения сотрудника на новую должность
     */
    public void startNewCareer(String newSpecialty) {
        if (specialty == null) {
            this.specialty = newSpecialty;
        } else {
            System.out.printf("Сотрудник %s должен сначала уволиться с текущей должности: %s", name, specialty);
        }
    }

    @Override
    public String toString() {
        return "Сотрудник: Имя - " + name +
                ", Дата рождения = " + birthDate +
                ", Должность - " + specialty;
    }
}
