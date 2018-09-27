package filterpattern;

import java.util.List;
import java.util.ArrayList;

public class FilterColorGreen implements Filter{
    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars = new ArrayList<Car>();
        for(Car car : cars){
            if(car.getColor().equals("Green")){
                filteredcars.add(car);
            }
        }
        return filteredcars;
    }
}