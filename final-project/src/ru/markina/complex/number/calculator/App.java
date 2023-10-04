package ru.markina.complex.number.calculator;

import ru.markina.complex.number.calculator.util.Level;
import ru.markina.complex.number.calculator.util.Logger;
import ru.markina.complex.number.calculator.util.LoggerFactory;
import ru.markina.complex.number.calculator.util.LoggerType;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new ComplexNumbersCalculator();
        Logger logger = LoggerFactory.logger(LoggableCalculator.class, LoggerType.CONSOLE, Level.TRACE);
        ViewCalculator viewCalculator = new ViewCalculator(new LoggableCalculator(logger, calculator));
        viewCalculator.run();
    }
}
