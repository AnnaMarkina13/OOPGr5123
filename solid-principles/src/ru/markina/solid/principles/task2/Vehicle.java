package ru.markina.solid.principles.task2;

//public class Vehicle {
//    int maxSpeed;
//    String type;
//    public Vehicle(int maxSpeed, String type) {
//        this.maxSpeed = maxSpeed;
//        this.type = type;
//    }
//    public int getMaxSpeed() {
//        return this.maxSpeed;
//    }
//    public String getType() {
//        return this.type;
//    }
//}

/**
 * Класс - транспортное средство с абстрактным методом calculateAllowedSpeed, которой необходимо переопределить
 * в классах-потомках
 */
public abstract class Vehicle {
    protected final int maxSpeed;
    protected final String type;

    public Vehicle(int maxSpeed, String type) {
        this.maxSpeed = maxSpeed;
        this.type = type;
    }

    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public String getType() {
        return this.type;
    }

    public abstract double calculateAllowedSpeed();
}

