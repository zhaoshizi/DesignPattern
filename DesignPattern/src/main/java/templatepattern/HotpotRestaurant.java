package templatepattern;

public class HotpotRestaurant extends Restaurant{
    @Override
    public void open(){
        System.out.println("HotpotRestaurant is opening.");
    }

    @Override
    public void makeFood(){
        System.out.println("HotpotRestaurant is making Food.");
    }

    @Override
    public void close(){
        System.out.println("HotpotRestaurant is closed.");
    }
}