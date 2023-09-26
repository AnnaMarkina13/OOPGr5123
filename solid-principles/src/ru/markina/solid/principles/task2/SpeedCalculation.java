package ru.markina.solid.principles.task2;

//public class SpeedCalculation {
//    public double calculateAllowedSpeed(Vehicle vehicle) {
//        if (vehicle.getType().equalsIgnoreCase("Car")) {
//
//        } else if (vehicle.getType().equalsIgnoreCase("Bus")) {
//            return vehicle.getMaxSpeed() * 0.6;
//        }
//        return 0.0;
//    }
//}

/**
 * Класс для подсчета разрешенной скорости
 * Метод calculateAllowedSpeed принимает объект класса Vehicle (или потомка)
 */
public class SpeedCalculation {

    private Vehicle vehicle;

    public double calculateAllowedSpeed(Vehicle vehicle) {
        return vehicle.calculateAllowedSpeed();
    }
}
