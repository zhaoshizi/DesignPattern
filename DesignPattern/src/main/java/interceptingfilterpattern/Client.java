package interceptingfilterpattern;

public class Client{
    public FilterManager filterManager;

    public void setFilterManager(FilterManager filterManager){
        this.filterManager = filterManager;
    }

    public void sendMessage(String request){
        filterManager.excute(request);
    }
}