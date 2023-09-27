package ru.markina.solid.principles.task3;

/**
 * Круг - планеметрическая фигуура, имплементирует интерфейс Shape
 */
public class Circle implements Shape {

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return 2 * 3.14 * radius;
    }
}
