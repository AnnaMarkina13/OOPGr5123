package ru.markina.student.app.domain.student.group;

/**
 * Класс, имплементирующий интерфейс Comparable для сортировки групп по идентификатору
 */
class StudentGroupIdComparable extends StudentGroup implements Comparable<StudentGroup> {

    public StudentGroupIdComparable(StudentGroup studentGroup) {
        super(studentGroup.studentGroup, studentGroup.groupId);
    }

    @Override
    public int compareTo(final StudentGroup o) {
        return Integer.compare(groupId, o.groupId);
    }
}
