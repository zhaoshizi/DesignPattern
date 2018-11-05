// 命令模式（Command Pattern）是一种数据驱动的设计模式，它属于行为型模式。
// 请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，
// 并把该命令传给相应的对象，该对象执行命令。

package commandpattern;

public class CommandPatternDemo{

    public static void main(String args[]){
        Fish fish = new Fish("FriedFish",20);

        CookDishOrder cookFishOrder = new CookDishOrder(fish);
        GetDishOrder getFishOrder = new GetDishOrder(fish);
        GetPaidOrder getFishPaidOrder = new GetPaidOrder(fish);
        WashPlateOrder washFishPlateOrder = new WashPlateOrder(fish);

        Restaurant restaurant = new Restaurant();
        restaurant.inpurtOrder(cookFishOrder);
        restaurant.inpurtOrder(getFishOrder);
        restaurant.inpurtOrder(getFishPaidOrder);
        restaurant.inpurtOrder(washFishPlateOrder);

        restaurant.executeOrders();

    }
}