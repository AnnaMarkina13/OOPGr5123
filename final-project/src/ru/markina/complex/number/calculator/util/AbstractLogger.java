package ru.markina.complex.number.calculator.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

/**
 * Абстрактный логгер, имплементирующий интерфейс Logger
 */
public abstract class AbstractLogger implements Logger {

    private final Level minLevel;
    private final Class<?> clazz;

    protected AbstractLogger(final Level minLevel, final Class<?> clazz) {
        this.minLevel = minLevel;
        this.clazz = clazz;
    }

    public abstract void log(String message);

    @Override
    public void log(final Level level, final Supplier<String> message) {
        if (level.compareTo(this.minLevel) >= 0) {
            final var dateText = DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now());
            log(clazz.getSimpleName() + ": [" + dateText + "] [" + level.name() + "] " + message.get());
        }
    }
}
