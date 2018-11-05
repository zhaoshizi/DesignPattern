package commandpattern;

public class CookDishOrder implements Order{
    public Dish dish;
    public CookDishOrder(Dish dish){
        this.dish = dish;
    }

    public void execute(){
        dish.cook();
    }
}