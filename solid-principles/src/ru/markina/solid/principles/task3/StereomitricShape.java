package ru.markina.solid.principles.task3;

/**
 * Интерфейс для стереометрических фигур с методом volume для подсчета объема фигуры
 * Наследует интерфейс Shape
 */
public interface StereomitricShape extends Shape {

    public double volume();
}
