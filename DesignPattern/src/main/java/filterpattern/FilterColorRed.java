package filterpattern;

import java.util.List;
import java.util.ArrayList;

public class FilterColorRed implements Filter{
    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars = new ArrayList<Car>();
        for(Car car : cars){
            if(car.getColor().equals("Red")){
                filteredcars.add(car);
            }
        }
        return filteredcars;
    }
}