package filterpattern;

import java.util.List;
import java.util.ArrayList;
public class FilterPriceExpensiveThan implements Filter{

    private double price;
    public FilterPriceExpensiveThan(double price){
        this.price = price;
    }
    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars = new ArrayList<Car>();
        for (Car car : cars){
            if (car.getPrice() >= price){
                filteredcars.add(car);
            }
        }
        return filteredcars;
    }

}