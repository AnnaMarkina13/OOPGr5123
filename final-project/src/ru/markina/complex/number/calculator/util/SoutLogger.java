package ru.markina.complex.number.calculator.util;

/**
 * Реализация логгера, выводящего сообщения в консоль
 */
class SoutLogger extends AbstractLogger {

    public SoutLogger(final Level minLevel, final Class<?> clazz) {
        super(minLevel, clazz);
    }

    @Override
    public void log(final String message) {
        System.out.println(message);
    }
}
