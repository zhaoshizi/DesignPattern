package factorypattern;

public class ConnectorFactory implements ComponentFactory{
    public Component getComponent(){
        return new Connector();
    }
}