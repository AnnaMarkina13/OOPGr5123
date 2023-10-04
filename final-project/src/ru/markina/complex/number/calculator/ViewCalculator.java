package ru.markina.complex.number.calculator;

import java.util.Scanner;

/**
 * Класс для реализации логики программы - запрашивания чисел и выбор операндов у пользователя,
 * вызов соответствующего метода калькулятора
 */
public class ViewCalculator {

    private final Calculator calculator;


    public ViewCalculator(final Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        var x1 = promptDouble("Введите x первого комплексного числа: ");
        var y1 = promptDouble("Введите y первого комплексного числа: ");
        var x2 = promptDouble("Введите x второго комплексного числа: ");
        var y2 = promptDouble("Введите y второго комплексного числа: ");

        var firstNumber = new ComplexNumber(x1, y1);
        var secondNumber = new ComplexNumber(x2, y2);

        var sign = prompt("Введите команду (+, *, /): ");

        switch (sign) {
            case "+" -> calculator.sum(firstNumber, secondNumber);
            case "*" -> calculator.multiply(firstNumber, secondNumber);
            case "/" -> calculator.division(firstNumber, secondNumber);
            default -> System.out.println("Неверная команда!");
        }
    }

    private String prompt(String message) {
        System.out.print(message);
        return new Scanner(System.in).nextLine();
    }

    private double promptDouble(String message) {
        System.out.print(message);
        return Double.parseDouble(new Scanner(System.in).nextLine());
    }
}
