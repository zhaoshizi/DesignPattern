//抽象工厂：对工厂方法进行扩展。各个工厂类中，再增加一个获得接口B实例的方法
package abstractfactorypattern;

public class AbstractFactoryPatternDemo {
    public static void main(String args[]){
        ComponentFactory connectoryFactory = FactoryProducer.GetComponentFactory("connector");
        connectoryFactory.getComponent().Todo();
        ComponentFactory processorFactory = FactoryProducer.GetComponentFactory("Processor");
        processorFactory.getComponent().Todo();

        ComponentFactory hithPriceFactory = FactoryProducer.GetComponentFactory("hith");
        hithPriceFactory.getPrice().itsPrice();
        ComponentFactory lowPriceFactory = FactoryProducer.GetComponentFactory("low");
        lowPriceFactory.getPrice().itsPrice();
        
    }
}