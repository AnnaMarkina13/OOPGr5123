package ru.markina.oop.base;

import java.util.List;

public interface MarketBehaviour {

    void acceptToMarket(Actor actor);

    void releaseFromMarket(List<Actor> actors);

    void update();

}
