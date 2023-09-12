package ru.markina.oop;

import ru.markina.oop.base.Actor;

public class TaxInspector implements Actor {

    private final String name;
    private boolean isOrderReceived;
    private boolean isOrdered;
    private boolean isReturned;

    public TaxInspector() {
        this.name = "Tax audit";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isOrderReceived() {
        return isOrderReceived;
    }

    @Override
    public void receiveOrder() {
        if (isOrdered) {
            isOrderReceived = true;
        } else {
            System.out.println("Невозможно получить заказ, так как он не заказан");
        }
    }

    @Override
    public boolean isOrdered() {
        return isOrdered;
    }

    @Override
    public void makeOrder() {
        if (!isOrdered) {
            this.isOrdered = true;
        } else {
            System.out.println("Уже заказано");
        }
    }

    @Override
    public void returnOrder() {
        if (this.isOrderReceived) {
            if (!isReturned) {
                isReturned = true;
            } else {
                System.out.println("Заказ уже возвращен");
            }
        } else {
            System.out.println("Невозможно вернуть заказ, так как он еще не получен");
        }
    }

    @Override
    public boolean isOrderReturned() {
        return false;
    }
}
