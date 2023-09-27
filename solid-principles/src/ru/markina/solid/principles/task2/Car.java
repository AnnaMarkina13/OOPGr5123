package ru.markina.solid.principles.task2;

public class Car extends Vehicle {

    public Car(final int maxSpeed, final String type) {
        super(maxSpeed, type);
    }

    @Override
    public double calculateAllowedSpeed() {
        return maxSpeed * 0.8;
    }
}
