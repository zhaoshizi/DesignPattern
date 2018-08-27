//简单工厂模式，一个工厂类生成不同的对象
package simplefactory;

public class SimpleFactoryDemo{
    public static void main(String args[]){
        ComponentFactory componentFactory = new ComponentFactory();
        Component processor = componentFactory.getComponent("Processor");
        processor.Todo();
        Component connector = componentFactory.getComponent("Connector");
        connector.Todo();

    }
}