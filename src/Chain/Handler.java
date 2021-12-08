package Chain;
import Model.*;

import java.util.ArrayList;

public interface Handler {
    boolean checkOrder(ArrayList<Order> checkOrders);
    void nextCheck(Handler next);

}
