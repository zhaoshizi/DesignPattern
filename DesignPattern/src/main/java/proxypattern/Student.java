package proxypattern;

public class Student implements People{
    public String buyDinner(String dinner,double price){
        System.out.println("buy dinner: " + dinner + " for " + price);
        return dinner;
    }
}