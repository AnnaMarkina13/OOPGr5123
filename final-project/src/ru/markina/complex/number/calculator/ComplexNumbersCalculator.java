package ru.markina.complex.number.calculator;

/**
 * Реализация интерфейса Calculator
 */
public class ComplexNumbersCalculator implements Calculator {

    @Override
    public ComplexNumber sum(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        return new ComplexNumber(firstNumber.real() + secondNumber.real(), firstNumber.real() + secondNumber.real());
    }

    @Override
    public ComplexNumber multiply(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        double realPartResult = firstNumber.real() * secondNumber.real() - firstNumber.image() * secondNumber.image();
        double imaginaryPartResult = firstNumber.real() * secondNumber.image() - secondNumber.real() * firstNumber.image();
        return new ComplexNumber(realPartResult, imaginaryPartResult);
    }

    @Override
    public ComplexNumber division(final ComplexNumber firstNumber, final ComplexNumber secondNumber) {
        double realPartResult = (firstNumber.real() * secondNumber.real() + firstNumber.image() * secondNumber.image()) /
                (Math.pow(secondNumber.real(), 2) + Math.pow(secondNumber.image(), 2));
        double imaginaryPartResult = (secondNumber.real() * firstNumber.image() - firstNumber.real() * secondNumber.image()) /
                (Math.pow(secondNumber.real(), 2) + Math.pow(secondNumber.image(), 2));
        return new ComplexNumber(realPartResult, imaginaryPartResult);
    }
}
