package commandpattern;

public class GetDishOrder implements Order{
    public Dish dish;
    public GetDishOrder(Dish dish){
        this.dish = dish;
    }

    public void execute(){
        dish.getTheDish();
    }
}