package ru.markina.solid.principles.task1;

/**
 * Класс с методом для реализации подсчета чистой зарплаты
 */
public class SalaryCalculateService {
    private Employee employee;

    public int calculateNetSalary() {
        int tax = (int) (employee.getBaseSalary() * 0.25);
        return employee.getBaseSalary() - tax;
    }
}
