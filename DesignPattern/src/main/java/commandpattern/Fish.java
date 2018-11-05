package commandpattern;

public class Fish implements Dish{

    public String name;
    public double price;
    public Fish(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Dish cook(){
        System.out.println("Cook fish.");
        return this;
    }

    public Dish getTheDish(){
        System.out.println("take the fish.");
        return this;
    }

    public double getPaid(){
        System.out.println("get paid the fish.Receive 20$");
        return this.price;
    }

    public void washPlate(){
        System.out.println("wash plate.");
    }
}