package ru.markina.complex.number.calculator;

import ru.markina.complex.number.calculator.util.Level;
import ru.markina.complex.number.calculator.util.Logger;

/**
 * Реализация паттерна Decorator - калькулятор теперь логгирует вычисления
 */
public class LoggableCalculator implements Calculator {

    private final Logger logger;
    private final Calculator calculator;

    public LoggableCalculator(final Logger logger, final Calculator calculator) {
        this.logger = logger;
        this.calculator = calculator;
    }

    @Override
    public ComplexNumber sum(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        logger.log(Level.TRACE, () -> String.format("Вызван метод 'sum'. Первое число - %s. Второе число - %s.", firstNumber, secondNumber));
        ComplexNumber result = calculator.sum(firstNumber, secondNumber);
        logger.log(Level.DEBUG, () -> String.format("Результат сложения чисел равен: %s", result));
        return result;
    }

    @Override
    public ComplexNumber multiply(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        logger.log(Level.TRACE, () -> String.format("Вызван метод 'multiply'. Первое число - %s. Второе число - %s.", firstNumber, secondNumber));
        ComplexNumber result = calculator.multiply(firstNumber, secondNumber);
        logger.log(Level.DEBUG, () -> String.format("Результат умножения чисел равен: %s", result));
        return result;
    }

    @Override
    public ComplexNumber division(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        logger.log(Level.TRACE, () -> String.format("Вызван метод 'division'. Первое число - %s. Второе число - %s.", firstNumber, secondNumber));
        ComplexNumber result = calculator.division(firstNumber, secondNumber);
        logger.log(Level.DEBUG, () -> String.format("Результат деления чисел равен: %s", result));
        return result;
    }
}
