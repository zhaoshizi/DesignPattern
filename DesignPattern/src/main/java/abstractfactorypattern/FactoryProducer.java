package abstractfactorypattern;

public class FactoryProducer {
    public static ComponentFactory GetComponentFactory(String type){
        if (type == null){
            return null;
        }
        else if (type.equalsIgnoreCase("Connector")){
            return new ConnectorFactory();
        }
        else if (type.equalsIgnoreCase("Processor")){
            return new ProcessorFactory();
        }
        else if (type.equalsIgnoreCase("hith")){
            return new HighPriceFactory();
        }
        else if (type.equalsIgnoreCase("low")){
            return new LowPriceFactory();
        }
        return null;
    }
}