package ru.markina.oop.base;

public interface Actor extends OrderInitializer, OrderReceiver, OrderReturner {

    String getName();
}
