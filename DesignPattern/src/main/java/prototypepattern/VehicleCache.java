package prototypepattern;
import java.util.HashMap;

public class VehicleCache{
    private static HashMap<String,Vehicle> hashmap= new HashMap<String, Vehicle>();

    public static Vehicle getVehicle(String name){
        return (Vehicle)hashmap.get(name).clone();
    }

    public static void loadcache(){
        Car car = new Car();
        car.setName("car1");
        Truck truck = new Truck();
        truck.setName("truck1");
        hashmap.put("Car", car);
        hashmap.put("Truck",truck);
    }
}