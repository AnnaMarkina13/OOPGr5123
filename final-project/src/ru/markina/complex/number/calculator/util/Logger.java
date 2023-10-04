package ru.markina.complex.number.calculator.util;

import java.util.function.Supplier;

/**
 * Интерфейс Логгер
 */
public interface Logger {

    void log(Level level, Supplier<String> message);

}
