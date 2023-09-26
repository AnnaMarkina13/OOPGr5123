package ru.markina.solid.principles.task4;

/**
 * В отличие от прямоугольника, у квадрата нет ширины и длины в том же понимании, есть сторона
 * Поэтому я решила, что неправильно наследовать данный класс от класса Rectangle
 * Вместо этого добавила интерфейс AreaCalculator, который имплементируют оба класса
 */
public class Square implements AreaCalculator {

    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return this.side * this.side;
    }
}
