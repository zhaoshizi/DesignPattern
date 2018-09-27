package filterpattern;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class FilterOr implements Filter{

    Filter oneFilter;
    Filter anotherFilter;

    public FilterOr(Filter one,Filter anthor){
        this.oneFilter = one;
        this.anotherFilter = anthor;
    }

    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars1 = oneFilter.filter(cars);
        List<Car> filteredcars2 = anotherFilter.filter(cars);
        filteredcars1.addAll(filteredcars2);
        return new ArrayList<Car>(new HashSet<Car>(filteredcars1));
    }
}