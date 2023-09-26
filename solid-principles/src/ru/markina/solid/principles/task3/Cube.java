package ru.markina.solid.principles.task3;

/**
 * Куб - стереометрическая фигуура, имплементирует интерфейс StereometricShape
 */
public class Cube implements StereomitricShape {

    private final int edge;

    public Cube(int edge) {
        this.edge = edge;
    }

    @Override
    public double area() {
        return 6 * edge * edge;
    }

    public double volume() {
        return edge * edge * edge;
    }
}
