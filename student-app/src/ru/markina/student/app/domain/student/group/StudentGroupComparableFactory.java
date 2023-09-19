package ru.markina.student.app.domain.student.group;

/**
 * Класс для инкапсуляции реализации механизма сравнения по id и количеству студентов
 */
public class StudentGroupComparableFactory {

    private StudentGroupComparableFactory() {
    }

    /**
     * @param studentGroup - группа студентов
     * @return объект класса StudentGroupSizeComparable, в котором реализован механизм сравнения по количеству студентов
     */
    public static StudentGroup bySize(StudentGroup studentGroup) {
        return new StudentGroupSizeComparable(studentGroup);
    }

    /**
     * @param studentGroup - группа студентов
     * @return объект класса StudentGroupIdComparable, в котором реализован механизм сравнения по id
     */
    public static StudentGroup byId(StudentGroup studentGroup) {
        return new StudentGroupIdComparable(studentGroup);
    }
}
