package interceptingfilterpattern;

import java.util.List;
import java.util.ArrayList;

public class FilterManager {
    public List<Filter> listFilter;
    public Target target;
    
    FilterManager() {
        listFilter= new ArrayList<Filter>();
        target = new Target();
    }

    public void setFilter(Filter filter) {
        listFilter.add(filter);
    } 

    public void setTarget(Target target){
        this.target = target;
    }

    public void excute(String request){
        for(Filter filter : listFilter){
            filter.excute(request);
        }
        target.excute(request);
    }

    
    
}