import domain.Bottle;
import domain.HotDrink;
import domain.Product;
import services.CoinDispenser;
import services.Holder;
import services.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Product item1 = new Product("Lays", 100);
        Product item2 = new Product("Cola", 50);
        Product item3 = new Bottle("Mineral water", 101, 1.5);
        Product item4 = new HotDrink("Tea", 15, 0.3, 100);
        Product item5 = new HotDrink("Coffee", 101, 0.2, 70);

        products.add(item1);
        products.add(item2);
        products.add(item3);
        products.add(item4);
        products.add(item5);

        Holder holder = new Holder(10, 10);
        CoinDispenser coinDispenser = new CoinDispenser(120);

        VendingMachine vendingMachine = new VendingMachine(holder, coinDispenser, products);

        for (final Product product : vendingMachine.getProductList()) {
            System.out.println(product);
        }
    }
}
