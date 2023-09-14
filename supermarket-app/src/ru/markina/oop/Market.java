package ru.markina.oop;

import ru.markina.oop.base.Actor;
import ru.markina.oop.base.MarketBehaviour;
import ru.markina.oop.base.QueueBehaviour;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Market implements MarketBehaviour, QueueBehaviour {

    private final Queue<Actor> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " клиент пришел в магазин");
        takeInQueue(actor);
    }

    @Override
    public void takeInQueue(Actor actor) {
        this.queue.add(actor);
        System.out.println(actor.getName() + " клиент добавлен в очередь");
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            System.out.println(actor.getName() + " клиент ушел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }

    @Override
    public void takeOrder() {
        for (Actor actor : queue) {
            if (!actor.isOrdered()) {
                actor.makeOrder();
                System.out.println(actor.getName() + " клиент сделал заказ");

            }
        }
    }

    @Override
    public void giveOrder() {
        for (Actor actor : queue) {
            if (actor.isOrdered() && !actor.isOrderReceived()) {
                actor.receiveOrder();
                System.out.println(actor.getName() + " клиент получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (Actor actor : queue) {
            if (actor.isOrderReceived()) {
                releaseActors.add(actor);
                System.out.println(actor.getName() + " клиент ушел из очереди");
            }
        }
        releaseFromMarket(releaseActors);
    }
}
