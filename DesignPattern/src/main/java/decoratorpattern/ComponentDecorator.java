package decoratorpattern;

public abstract class ComponentDecorator implements Component{

    protected Component componentDecorator;

    ComponentDecorator(Component component){
        this.componentDecorator = component;
    }

    public void Todo(){
        componentDecorator.Todo();

    }
}