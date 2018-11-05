package commandpattern;

import java.util.ArrayList;
import java.util.List;

public class Restaurant{
    List<Order> orderList = new ArrayList<Order>();

    public List<Order> inpurtOrder(Order order){
        orderList.add(order);
        return orderList;
    }

    public void executeOrders(){
        for (Order i : orderList){
            i.execute();
        }
        orderList.clear();
    }

}
