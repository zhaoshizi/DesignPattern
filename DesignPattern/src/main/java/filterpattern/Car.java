package filterpattern;

public class Car{
    private String color;
    private double price;
    private String brand;

    public Car(String color,double price,String brand){
        this.color = color;
        this.price = price;
        this.brand = brand;
    }

    public String getColor(){
        return color;
    }
    public double getPrice(){
        return price;
    }
    public String getBrand(){
        return brand;
    }
}