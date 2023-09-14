package ru.markina.oop;

import ru.markina.oop.base.AbstractActor;

public class OrdinaryClient extends AbstractActor {

    public OrdinaryClient(String name) {
        super(name);
    }

    public AbstractActor getActor() {
        return this;
    }

    @Override
    public String getName() {
        return super.name;
    }
}
