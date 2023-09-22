package ru.markina.mvc.student.app.model;

import ru.markina.mvc.student.app.controller.interfaces.GetModel;
import ru.markina.mvc.student.app.model.core.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ModelClassHash implements GetModel {

    private final Map<Long, Student> studentById;

    /**
     * В конструктор принимаем список студентов, который преобразуем в мапу с ключом - id студента
     * @param students
     */
    public ModelClassHash(List<Student> students) {
        this.studentById = students.stream().collect(Collectors.toMap(Student::getId, Function.identity()));
    }

    /**
     * Метод для добавления студента в мапу
     * @param student - студент, которого необходимо добавить
     * @return мапа
     */
    public Map<Long, Student> addStudentToMap(Student student) {
        studentById.put(student.getId(), student);
        return studentById;
    }

    /**
     * Метод для удаления студента из группы
     * @param id - id студента
     * @return студент, которого удалили, либо, если студента с таким id нет в группе, - null
     */
    @Override
    public Student deleteStudent(Long id) {
        if (studentById.containsKey(id)) {
            System.out.printf("Студент под номером %d удален.\n", id);
             return studentById.remove(id);
        } else {
            System.out.println("Студента с таким id нет.");
            return null;
        }
    }

    /**
     * Метод для возврата списка студентов
     */
    @Override
    public List<Student> students() {
        return studentById.values().stream().toList();
    }
}
