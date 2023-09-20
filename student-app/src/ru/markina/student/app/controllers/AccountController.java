package ru.markina.student.app.controllers;

import ru.markina.student.app.domain.Employee;
import ru.markina.student.app.domain.Person;

import java.util.List;

public class AccountController {

    public static <T extends Employee> void paySalary(T person, int salary) {
        System.out.printf("Сотруднику по имени %s выплачена зарплата в размере %d рублей.\n", person.getName(), salary);
    }

    /**
     * Статический метод для подсчета среднего возраста людей в списке с элементами-наследниками Person
     * @param persons - список Person
     * @return средний возраст
     */
    public static <T extends Person> double averageAge(List<T> persons) {
        var sum = 0;
        for (final T person : persons) {
            sum += person.getAge();
        }
        return sum / (persons.size() * 1.0);
    }
}
