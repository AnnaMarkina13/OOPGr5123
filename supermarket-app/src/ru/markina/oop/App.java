package ru.markina.oop;

import ru.markina.oop.Market;
import ru.markina.oop.OrdinaryClient;
import ru.markina.oop.PromotionalClient;
import ru.markina.oop.SpecialClient;
import ru.markina.oop.TaxInspector;
import ru.markina.oop.base.Actor;

public class App {

    public static void main(String[] args) {

        var magnit = new Market();

        Actor client1 = new OrdinaryClient("Илья");
        Actor client2 = new SpecialClient("Билл Гейтс");
        Actor client3 = new TaxInspector();
        Actor client4 = new PromotionalClient("Sergey", "2-1");

        magnit.acceptToMarket(client1);
        magnit.acceptToMarket(client2);
        magnit.acceptToMarket(client3);
        magnit.acceptToMarket(client4);

        magnit.update();

        client1.returnOrder();

    }
}
