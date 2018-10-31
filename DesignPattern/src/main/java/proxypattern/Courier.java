package proxypattern;

public class Courier implements People{
    People p;
    Courier(People p){
        this.p = p;
    }
    public String buyDinner(String dinner,double price){
        System.out.println("I have coupons.");
        p.buyDinner(dinner,price-5);
        return dinner;
    }
}