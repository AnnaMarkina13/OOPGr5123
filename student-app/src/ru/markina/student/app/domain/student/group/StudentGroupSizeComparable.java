package ru.markina.student.app.domain.student.group;

/**
 * Класс, имплементирующий интерфейс Comparable для сортировки групп по количеству студентов
 */
class StudentGroupSizeComparable extends StudentGroup implements Comparable<StudentGroup> {

    public StudentGroupSizeComparable(StudentGroup studentGroup) {
        super(studentGroup.studentGroup, studentGroup.groupId);
    }

    @Override
    public int compareTo(final StudentGroup o) {
        return Integer.compare(studentGroup.size(), o.studentGroup.size());
    }
}
