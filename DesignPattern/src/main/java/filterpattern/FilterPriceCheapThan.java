package filterpattern;

import java.util.List;
import java.util.ArrayList;
public class FilterPriceCheapThan implements Filter{

    private double price;
    public FilterPriceCheapThan(double price){
        this.price = price;
    }
    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars = new ArrayList<Car>();
        for (Car car : cars){
            if (car.getPrice() < price){
                filteredcars.add(car);
            }
        }
        return filteredcars;
    }

}