package templatepattern;

public class SushiRestaurant extends Restaurant{
    @Override
    public void open(){
        System.out.println("SushiRestaurant is opening.");
    }

    @Override
    public void makeFood(){
        System.out.println("SushiRestaurant is making Food.");
    }

    @Override
    public void close(){
        System.out.println("SushiRestaurant is closed.");
    }
}