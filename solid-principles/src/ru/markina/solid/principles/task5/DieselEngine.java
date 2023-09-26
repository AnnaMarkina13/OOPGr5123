package ru.markina.solid.principles.task5;

/**
 * Класс дизельный двигатель, имплементирует интерфейс Engine
 */
public class DieselEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Diesel engine started");
    }
}
