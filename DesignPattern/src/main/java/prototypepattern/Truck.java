package prototypepattern;

public class Truck extends Vehicle{

    public Truck(){
        this.type = "Truck";
    }
    @Override
    public void run(){
        System.out.println("Truck:rum slow.");
    }
}