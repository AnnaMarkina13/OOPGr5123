package ru.markina.solid.principles.task5;

//public class Car {
//    private PetrolEngine engine;
//    public Car(PetrolEngine engine) {
//        this.engine = engine;
//    }
//    public void start() {
//        this.engine.start();
//    }
//}
//public class PetrolEngine {
//    public void start() {
//    }

/**
 * Класс машина, зависит от объекта, реализующего интерфейс Engine (может быть как с бензиновым, так и с
 * дизельным двигателем)
 */
public class Car {

    private final Engine engine;
    public Car(Engine engine) {
        this.engine = engine;
    }
    public void start() {
        engine.start();
    }
}
