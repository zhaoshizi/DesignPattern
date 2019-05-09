package interceptingfilterpattern;

public class LogFilter implements Filter{
    @Override
    public void excute(String request){
        System.out.println("Log: " + request);
    }
}