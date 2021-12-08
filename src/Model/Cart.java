package Model;

import Chain.LimitHandler;
import Chain.StockHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Cart {
     private ArrayList<Order> checkoutOrder = new ArrayList<>();
    private double totalPrice = 0;
    private Inventory inStock = Inventory.getInstance();

    //Chain
    StockHandler checkStock = new StockHandler();
    LimitHandler checkLimit = new LimitHandler();


    //read from inputfile
    public void getInput(String filePath) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] lines = line.split(",");

                int quantity = Integer.parseInt(lines[1]);
                checkoutOrder.add(new Order(lines[0], quantity, lines[2]));
//                System.out.println(quantity);
//                System.out.println(lines[0]);

//                System.out.println(checkoutOrder);
            }

        } catch (IOException e) {
            System.out.println("Input Error");
            e.printStackTrace();
        }
        System.out.println(checkoutOrder);
    }

    //read from the dataset file
    public void getData(String filePath) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] lines = line.split(",");

                int quantity = Integer.parseInt(lines[2]);
                double price = Double.parseDouble(lines[3]);
                inStock.getStockOrder().put(lines[1], new Stock( lines[0], lines[1], quantity,price));
//                System.out.println(inStock.getStockOrder());
//                System.out.println(price);

            }

        } catch (IOException e) {
            System.out.println("Data Error");
            e.printStackTrace();
        }

    }

    public void getCardFile(String filePath) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            br.readLine();
            while ((line = br.readLine()) != null)
            {
                String[] lines = line.split(",");

                inStock.getCreditCards().add(lines[0]);
            }

        } catch (IOException e) {
            System.out.println("Card Error");
            e.printStackTrace();
        }
        System.out.println(inStock.getCreditCards());
    }



    public void setTotal() {

            for (Order item : checkoutOrder) {
                totalPrice += item.getQuantity() * inStock.getStockOrder().get(item.getItemName()).getPrice();
//            System.out.println(item.getQuantity());
//            System.out.println(inStock.getStockOrder().get(item.getItemName()));
//                if (inStock.getStockOrder().get(item.getItemName()).getCategory() == ("Essential") )
            }

    }



    public double getTotal() {
        return totalPrice;
    }

    public void setNewCreditCards() {
        for (Order item : checkoutOrder) {
            inStock.getCreditCards().add(item.getCreditCardNum());
        }
        System.out.println(inStock.getCreditCards());
    }

    public void checkout() {
//        if (checkStock.checkOrder(checkoutOrder)) {
        checkStock.nextCheck(checkLimit); //chain
//            if (checkLimit.checkOrder(checkoutOrder)) {
        if (checkStock.checkOrder(checkoutOrder)) {
            try {
                FileWriter myWriter = new FileWriter("output.txt");
                myWriter.write("Total ammount paid" + "\n" + totalPrice);
                System.out.println(("Total ammount paid" + "\n" + totalPrice));

                myWriter.close();
                System.out.println("Successful checkout");
            } catch (IOException e) {
                System.out.println("Checkout Error");
                e.printStackTrace();
            }
        }else System.out.println("Limit Error");
    }


}
