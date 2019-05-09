package interceptingfilterpattern;

public class Target{
    public void excute(String request){
        System.out.println("Target: " + request);
    }
}