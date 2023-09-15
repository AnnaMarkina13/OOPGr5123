package ru.markina.student.app.domain;

import ru.markina.student.app.domain.id.IdProducer;
import ru.markina.student.app.domain.student.group.StudentGroup;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentStream implements Iterable<StudentGroup> {

    /**
     * Класс - поток групп в университете
     * Реализует Iterable
     * studentStreamId - номер потока
     * studentGroups - список групп в потоке
     */
    private final int studentStreamId;
    private final List<StudentGroup> studentGroups;

    public StudentStream(final List<StudentGroup> studentGroups, final IdProducer<Integer> idProducer) {
        this.studentGroups = studentGroups;
        this.studentStreamId = idProducer.nextId();
    }

    public int getStudentStreamId() {
        return studentStreamId;
    }

    public List<StudentGroup> getStudentGroups() {
        return studentGroups;
    }

    @Override
    public String toString() {
        return "Поток №" + studentStreamId +
                ". Количество групп в потоке - " + studentGroups.size() +
                ". Список групп в потоке: " + studentGroups;
    }

    @Override
    public Iterator<StudentGroup> iterator() {
        return new StudentStreamIterator(studentGroups);
    }

    /**
     * Статический класс - итератор для реализации Iterable классом StudentStream
     */
    protected static class StudentStreamIterator implements Iterator<StudentGroup> {
        private int count;
        private final List<StudentGroup> studentGroups;

        public StudentStreamIterator(List<StudentGroup> studentGroups) {
            this.studentGroups = studentGroups;
        }

        @Override
        public boolean hasNext() {
            return count < studentGroups.size();
        }

        @Override
        public StudentGroup next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return studentGroups.get(count++);
        }
    }
}
