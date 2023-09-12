package ru.markina.oop.base;

/**
 * Добавила отдельный интерфейс для создания заказа
 * Вынесла соответствующие методы из интерфейса Actor
 */
public interface OrderInitializer {

    boolean isOrdered();

    void makeOrder();
}
