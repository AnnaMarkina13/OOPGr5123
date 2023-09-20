package ru.markina.student.app.services;

import ru.markina.student.app.domain.Employee;
import ru.markina.student.app.domain.PersonComparators;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements PersonService<Employee> {

    private final List<Employee> employees;
    private final String defaultSpecialty;

    public EmployeeService(final String defaultSpecialty) {
        this.defaultSpecialty = defaultSpecialty;
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getAll() {
        return employees;
    }

    @Override
    public Employee create(final String name, final LocalDate birthDate) {
        return create(name, birthDate, defaultSpecialty);
    }

    public Employee create(final String name, final LocalDate birthDate, final String defaultSpecialty) {
        var employee = new Employee(name, birthDate, defaultSpecialty);
        employees.add(employee);
        return employee;
    }

    /**
     * Метод для сортировки работников по имени
     * @return отортированный список сотрудников
     */
    public List<Employee> getOrderedByName() {
        employees.sort(PersonComparators.personByNameComparator());
        return employees;
    }

    /**
     * Метод для сортировки сотрудников по возрасту
     * @return отортированный список сотрудников
     */
    public List<Employee> getOrderedByAge() {
        employees.sort(PersonComparators.personComparator(Employee::getAge));
        return employees;
    }
}
