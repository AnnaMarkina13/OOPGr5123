package ru.markina.oop.base;

/**
 * Добавила отдельный интерфейс для получения заказа
 * Вынесла соответствующие методы из интерфейса Actor
 */
public interface OrderReceiver {

    boolean isOrderReceived();

    void receiveOrder();
}
