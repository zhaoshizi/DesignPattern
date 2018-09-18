package builderpattern;
import java.util.List;
import java.util.ArrayList;

public class Meal{
    List<Item> itemList = new ArrayList<Item>();

    public void addItem(Item i){
        itemList.add(i);
    }

    public void showItems(){
        for(Item i : itemList){
            System.out.print("Item: " + i.name());
            System.out.print(", Packing: " + i.packing().pack());
            System.out.println(", Price: " + i.price());
        }
    }

    public float getCost(){
        float sum = 0.0f;
        for (Item i : itemList){
            sum += i.price();
        }
        return sum;
    }
}