package prototypepattern;

public class Car extends Vehicle{
    public Car(){
        this.type = "Car";
    }
    @Override
    public void run(){
        System.out.println("car:run fast.");
    }
}