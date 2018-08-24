package decoratorpattern;
public class DecoratorPatternDemo{
    
    public static void main(String args[]){
        Processer processer = new Processer();
        Connector connector = new Connector();

        processer.Todo();
        connector.Todo();

        ComponentWithEncode connectorWithEncode = new ComponentWithEncode(new Connector());
        ComponentWithEncode processerWithEncode = new ComponentWithEncode(new Processer());

        connectorWithEncode.Todo();
        processerWithEncode.Todo();

    }
}