package commandpattern;

public class WashPlateOrder implements Order{
    public Dish dish;
    public WashPlateOrder(Dish dish){
        this.dish = dish;
    }

    public void execute(){
        dish.washPlate();
    }
}