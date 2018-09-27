package filterpattern;

import java.util.ArrayList;
import java.util.List;

public class FilterPatternDemo{
    public static void main(String arvg[]){
        List<Car> listCars = new ArrayList<Car>();
        listCars.add(new Car("Red",100000,"Audi"));
        listCars.add(new Car("Green",200000,"Benz"));
        listCars.add(new Car("Blank",300000,"BMW"));
        listCars.add(new Car("Write",150000,"Audi"));
        listCars.add(new Car("Yellow",220000,"BMW"));
        listCars.add(new Car("Red",400000,"Audi"));

        Filter filterRed = new FilterColorRed();
        Filter filterGreen = new FilterColorGreen();
        Filter filterPriceExpensiveThan = new FilterPriceExpensiveThan(200000);
        Filter filterPriceCheapThan = new FilterPriceCheapThan(150000);
        Filter filterAnd = new FilterAnd(filterRed, filterPriceExpensiveThan);
        Filter filterOr = new FilterOr(filterGreen,filterPriceCheapThan);

        List<Car> listRedCars =  filterRed.filter(listCars);
        listRedCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
        System.out.println("----------");
        List<Car> listGreenCars = filterGreen.filter(listCars);
        listGreenCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
        System.out.println("----------");
        List<Car> listExpensiveCars = filterPriceExpensiveThan.filter(listCars); 
        listExpensiveCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
        System.out.println("----------");
        List<Car> listCheapCars = filterPriceCheapThan.filter(listCars);
        listCheapCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
        System.out.println("----------");
        List<Car> listAndCars = filterAnd.filter(listCars);
        listAndCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
        System.out.println("----------");
        List<Car> listOrCars = filterOr.filter(listCars);
        listOrCars.forEach((car)->System.out.println("Color:" + car.getColor() + " Price:" + car.getPrice() + " Brand:" + car.getBrand()));
       


    }
}