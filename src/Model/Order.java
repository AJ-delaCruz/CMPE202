package Model;


public class Order {

    private String itemName;
    private int quantity;
    private String creditCardNum;

    public Order(String itemName, int quantity, String creditCardNum) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.creditCardNum = creditCardNum;
    }

    public Order() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", creditCardNum='" + creditCardNum + '\'' +
                '}';
    }
}