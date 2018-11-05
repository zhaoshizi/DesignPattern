package commandpattern;

public class GetPaidOrder implements Order{
    public Dish dish;
    public GetPaidOrder(Dish dish){
        this.dish = dish;
    }

    public void execute(){
        dish.getPaid();
    }
}