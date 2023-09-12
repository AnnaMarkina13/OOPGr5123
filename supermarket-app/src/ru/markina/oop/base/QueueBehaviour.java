package ru.markina.oop.base;

public interface QueueBehaviour {

    void takeInQueue(Actor actor);

    void releaseFromQueue();

    void takeOrder();

    void giveOrder();
}
