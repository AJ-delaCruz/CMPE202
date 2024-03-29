package Model;

import java.util.HashMap;
import java.util.HashSet;


//singleton
public class Inventory {
    private static Inventory instance;
    private HashMap<String, Stock> stockOrder = new HashMap<>();
    private HashSet<String> creditCards = new HashSet<>();


    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }


    public HashMap<String, Stock> getStockOrder() {
        return stockOrder;
    }

    public HashSet<String> getCreditCards() {
        return creditCards;
    }


}
