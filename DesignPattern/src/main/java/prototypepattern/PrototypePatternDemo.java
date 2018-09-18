package prototypepattern;

public class PrototypePatternDemo{

    public static void main(String arvg[]){
        VehicleCache.loadcache();

        Vehicle car1 = VehicleCache.getVehicle("Car");
        Vehicle truck1 = VehicleCache.getVehicle("Truck");

        car1.run();
        truck1.run();
    }
}