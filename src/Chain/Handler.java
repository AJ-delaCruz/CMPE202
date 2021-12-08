package Chain;
import Model.*;

import java.util.ArrayList;

public interface Handler {
    public boolean checkOrder(ArrayList<Order> checkOrders);

    public void nextCheck(Handler next);

}
