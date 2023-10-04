package ru.markina.complex.number.calculator.util;

/**
 * Реализация паттерна Factory для управления создания объекта-логгера
 */
public class LoggerFactory {

    public static Logger logger(Class<?> clazz, LoggerType loggerType, Level level) {
        return switch (loggerType) {
            case CONSOLE -> new SoutLogger(level, clazz);
        };
    }
}
