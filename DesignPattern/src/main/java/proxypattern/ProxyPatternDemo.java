package proxypattern;

public class ProxyPatternDemo{

    public static void main(String argv[]){
        People student = new Student();
        People peopleProxy = new Courier(student);
        peopleProxy.buyDinner("KFC", 25);
    }
}