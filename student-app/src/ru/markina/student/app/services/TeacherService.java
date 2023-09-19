package ru.markina.student.app.services;

import ru.markina.student.app.domain.PersonComparators;
import ru.markina.student.app.domain.Teacher;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TeacherService implements PersonService<Teacher> {

    private final List<Teacher> teachers;

    public TeacherService() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }

    @Override
    public Teacher create(final String name, final LocalDate birthDate) {
        return create(name, birthDate, null);
    }

    public Teacher create(final String name, final LocalDate birthDate, final Teacher.AcademicDegree academicDegree) {
        var teacher = new Teacher(name, birthDate, academicDegree);
        teachers.add(teacher);
        return teacher;
    }

    /**
     * Метод для сортировки учителей по имени
     * @return отортированный список учителей
     */
    public List<Teacher> getOrderedByName() {
        teachers.sort(PersonComparators.personByNameComparator());
        return teachers;
    }

    /**
     * Метод для сортировки учителей по возрасту (дате рождения)
     * @return отортированный список учителей
     */
    public List<Teacher> getOrderedByAge() {
        teachers.sort(PersonComparators.personComparator(Teacher::getAge));
        return teachers;
    }

    /**
     * Метод для вывода списка отсортированных по одному из признаков учителей
     * @param comparator - компаратор для сортировки учителей
     * @param teacherConsumer - объект, реализующий функциональный интерфейс Consumer
     *                        (принимает в качестве аргумента Teacher и ничего не возвращает)
     */
    public void showOrdered(Comparator<? super Teacher> comparator, Consumer<? super Teacher> teacherConsumer) {
        teachers.stream()
                .sorted(comparator)
                .forEach(teacherConsumer);
    }
}
