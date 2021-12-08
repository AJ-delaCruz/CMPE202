import Chain.Handler;
import Chain.StockHandler;
import Model.Cart;
import Model.Inventory;

public class Main {

    private static Inventory inStock = Inventory.getInstance();


    public static void main(String[] args) {
        String input1 = "Input1 - Sheet1.csv";
        String input2 = "Input2 - Sheet1.csv";
        String input3 = "Input3 - Sheet1.csv";

        String cards = "Cards - Sheet1.csv";
        String dataSet ="Dataset.csv";

        Cart newCart = new Cart();
        //add files
        newCart.getInput(input2);

        newCart.getData(dataSet);
        newCart.getCardFile(cards);

        //checkout
        newCart.setTotal();
        newCart.setNewCreditCards();
        newCart.checkout();

//        System.out.println(inStock.getCreditCards());
////        newCart.getCreditCards();
//        System.out.println();
//        newCart.setNewCreditCards();
//        System.out.println(inStock.getCreditCards());




//
//
//        newCart.setTotal();
////        System.out.println(inStock.getStockOrder().get("Milk"));
//       System.out.println(newCart.getTotal());





    }



}