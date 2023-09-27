package ru.markina.solid.principles.task2;

public class Bus extends Vehicle {

    public Bus(final int maxSpeed, final String type) {
        super(maxSpeed, type);
    }

    @Override
    public double calculateAllowedSpeed() {
        return maxSpeed * 0.6;
    }
}
