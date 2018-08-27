package abstractfactorypattern;

public class ConnectorFactory implements ComponentFactory{
    public Component getComponent(){
        return new Connector();
    }
    public Price getPrice(){
        return null;
    }
}