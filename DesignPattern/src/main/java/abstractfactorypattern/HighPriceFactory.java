package abstractfactorypattern;

public class HighPriceFactory implements ComponentFactory{
    public Price getPrice(){
        return new HighPrice();
    }
    public Component getComponent(){
        return null;
    }
}
