package ru.markina.complex.number.calculator;

/**
 * Интерфейс калькулятора с методами для сложения, умножения и деления комплексных чисел
 */
public interface Calculator {
    ComplexNumber sum(ComplexNumber firstNumber, ComplexNumber secondNumber);

    ComplexNumber multiply(ComplexNumber firstNumber, ComplexNumber secondNumber);

    ComplexNumber division(ComplexNumber firstNumber, ComplexNumber secondNumber);

}
