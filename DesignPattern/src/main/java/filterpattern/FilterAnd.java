package filterpattern;

import java.util.List;

public class FilterAnd implements Filter{

    Filter oneFilter;
    Filter anotherFilter;

    public FilterAnd(Filter one,Filter anthor){
        this.oneFilter = one;
        this.anotherFilter = anthor;
    }

    public List<Car> filter(List<Car> cars){
        List<Car> filteredcars = oneFilter.filter(cars);
        return anotherFilter.filter(filteredcars);
    }
}