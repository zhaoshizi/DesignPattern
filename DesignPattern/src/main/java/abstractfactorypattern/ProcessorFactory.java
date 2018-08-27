package abstractfactorypattern;

public class ProcessorFactory implements ComponentFactory{
    public Component getComponent(){
        return new Processor();
    }
    public Price getPrice(){
        return null;
    }
}