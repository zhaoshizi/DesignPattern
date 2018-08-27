package factorypattern;

public class ProcessorFactory implements ComponentFactory{
    public Component getComponent(){
        return new Processor();
    }
}