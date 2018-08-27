//工厂模式，建多个工厂类。各个工厂类中，都对应一个获得接口A实例的方法。用户决定使用哪个工厂。
//是抽象工厂模式的特例
package factorypattern;

public class FactoryPatternDemo {
    public static void main(String args[]){
        ComponentFactory connectoryFactory = FactoryProducer.GetComponentFactory("connector");
        connectoryFactory.getComponent().Todo();
        ComponentFactory processorFactory = FactoryProducer.GetComponentFactory("Processor");
        processorFactory.getComponent().Todo();
    }
}