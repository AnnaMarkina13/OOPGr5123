package ru.markina.student.app.domain;

import ru.markina.student.app.services.EmployeeService;

import java.time.LocalDate;

public class Teacher extends Employee {

    /**
     * поле academicDegree - ученая степень
     * реализован enum для ученых степеней
     */
    private AcademicDegree academicDegree;

    public Teacher(String name, LocalDate birthDate) {
        super(name, birthDate, "учитель");
    }

    public Teacher(String name, LocalDate birthDate, AcademicDegree academicDegree) {
        super(name, birthDate, "учитель");
        this.academicDegree = academicDegree;
    }

    public AcademicDegree getAcademicDegree() {
        return academicDegree;
    }

    /**
     * Метод для повышения ученой степени
     */
    public void upgrade() {
        if (academicDegree == null) {
            academicDegree = AcademicDegree.CANDIDATE;
        } else if (academicDegree.nextLevel != null) {
            academicDegree = academicDegree.nextLevel;
        } else {
            System.out.printf("Преподаватель %s уже имеет высшую ученую степень - %s", name, academicDegree);
        }
    }

    @Override
    public String toString() {
        return "Учитель: Имя - " + name +
                ", Дата рождения = " + birthDate;
    }

    public enum AcademicDegree {
        DOCTOR(null),
        CANDIDATE(DOCTOR);

        private final AcademicDegree nextLevel;

        AcademicDegree(final AcademicDegree nextLevel) {
            this.nextLevel = nextLevel;
        }
    }
}
