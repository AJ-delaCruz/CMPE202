package Chain;

import Model.*;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class StockHandler implements Handler {
    private Handler next = null;
    private Inventory inStock = Inventory.getInstance();

    @Override
    public boolean checkOrder(ArrayList<Order> checkQuantity) {

        //check inventory if enough stock available
//        String oos = "";
//        double oosNum = 0;
        for (Order listStock : checkQuantity) {
            if (inStock.getStockOrder().get(listStock.getItemName()).getQuantity() < listStock.getQuantity()) {
                try {
                    FileWriter myWriter = new FileWriter("errors.txt");
                    myWriter.write("Please correct quantities" + "\n" + listStock.getItemName() + ", " + listStock.getQuantity());

                    myWriter.close();
                    System.out.println("Please correct quantities" + "\n" + listStock.getItemName() + ", " + listStock.getQuantity());
                } catch (IOException e) {
                    System.out.println("Error");
                    e.printStackTrace();
                }
                return false;
            }

//            System.out.println("Please correct quantities " + oosNum + " for " + oos);


        }
        return true;
    }

    @Override
    public void nextCheck(Handler next) {
        this.next = next;
    }

}
