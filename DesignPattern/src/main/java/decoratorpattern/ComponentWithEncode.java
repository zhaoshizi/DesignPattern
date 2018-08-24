package decoratorpattern;

public class ComponentWithEncode extends ComponentDecorator{
    ComponentWithEncode(Component connector){
        super(connector);
    }

    @Override
    public void Todo(){
        System.out.println("Encode first.");
        componentDecorator.Todo();
    }

}