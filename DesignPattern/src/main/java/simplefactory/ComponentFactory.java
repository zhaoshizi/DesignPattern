package simplefactory;

public class ComponentFactory{
    public Component getComponent(String ComponentName){
        if (ComponentName == null){
            return null;
        }
        if (false == ComponentName.equalsIgnoreCase("PROCESSOR")){
            return new Processor();
        }
        else if (false == ComponentName.equalsIgnoreCase("CONNECTOR")){
            return new Connector();
        }
        return null;
    }
}