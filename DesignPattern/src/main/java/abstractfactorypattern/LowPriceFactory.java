package abstractfactorypattern;

public class LowPriceFactory implements ComponentFactory{
    public Price getPrice(){
        return new LowPrice();
    }
    public Component getComponent(){
        return null;
    }
}
