package ru.markina.student.app.domain.student.group;

import ru.markina.student.app.domain.id.IdProducer;
import ru.markina.student.app.domain.student.Student;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentGroup implements Iterable<Student> {

    protected final List<Student> studentGroup;
    protected final int groupId;

    public StudentGroup(List<Student> studentGroup, IdProducer<Integer> idProducer) {
        this.studentGroup = studentGroup;
        this.groupId = idProducer.nextId();
    }

    protected StudentGroup(List<Student> studentGroup, int groupId) {
        this.studentGroup = studentGroup;
        this.groupId = groupId;
    }

    public List<Student> getStudentGroup() {
        return studentGroup;
    }

    public int getGroupId() {
        return groupId;
    }

    /**
     * Метод для добавления нового студента в группу
     * @param newStudent - студент, которого необходимо добавить
     */
    public void addStudent(Student newStudent) {
        if (studentGroup.contains(newStudent)) {
            System.out.printf("Студент %s уже есть в данной группе\n", newStudent);
        } else {
            studentGroup.add(newStudent);
        }
    }

    /**
     * Метод для отчисления студента из группы
     * @param name - имя отчисляемого студента
     */
    public void kickStudent(String name) {
        if (!studentGroup.removeIf(s -> s.getName().equals(name))) {
            System.out.printf("Студент с именем %s отсутстует в данной группе\n", name);
        }
    }

    @Override
    public String toString() {
        return "Группа №" + groupId +
                ". Количество студентов в группе - " + studentGroup.size() +
                ". Список студентов группы: " + studentGroup;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(studentGroup);
    }

    /**
     * Статический класс - итератор для реализации Iterable классом StudentGroup
     */
    protected static class StudentGroupIterator implements Iterator<Student> {

        private int count;
        private final List<Student> students;

        public StudentGroupIterator(List<Student> students) {
            this.students = students;
        }

        @Override
        public boolean hasNext() {
            return count < students.size();
        }

        @Override
        public Student next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return students.get(count++);
        }
    }
}
