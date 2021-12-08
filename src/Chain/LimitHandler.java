package Chain;

import Model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LimitHandler implements Handler {
    private Handler next = null;
    private Inventory inStock = Inventory.getInstance();

    @Override
    public boolean checkOrder(ArrayList<Order> checkOrders) {
        int essential = 3;
        int luxury = 5;
        int misc = 6;
        for (Order listOfStocks : checkOrders) {
            if ( ((inStock.getStockOrder().get(listOfStocks.getItemName()).getCategory()).equalsIgnoreCase("Essential") &&
                    essential < listOfStocks.getQuantity())
                    || ((inStock.getStockOrder().get(listOfStocks.getItemName()).getCategory()).equalsIgnoreCase("Luxury") &&
                    luxury < listOfStocks.getQuantity())
                    || ((inStock.getStockOrder().get(listOfStocks.getItemName()).getCategory()).equalsIgnoreCase("Misc") &&
                    misc < listOfStocks.getQuantity())
            ) {
                try {
                    FileWriter myWriter = new FileWriter("errors.txt");
                    myWriter.write("Reached category limit per order" + "\n" + listOfStocks.getItemName() + ", " + listOfStocks.getQuantity());

                    myWriter.close();
                    System.out.println("Reached category limit per order" + "\n" + listOfStocks.getItemName() + ", " + listOfStocks.getQuantity());
                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
                return false;
            }
        }

        return true;
    }

    @Override
    public void nextCheck(Handler next) {
        this.next = next;
    }
}