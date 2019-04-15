//当对象间存在一对多关系时，则使用观察者模式（Observer Pattern）。
//比如，当一个对象被修改时，则会自动通知它的依赖对象。观察者模式属于行为型模式。
package observerpattern;

public class ObserverPatternDemo{
    public static void main(String args[]){
        Subject subject = new Subject("work");
        Observer farmer = new Farmer(subject);
        Observer worker = new Worker(subject);
        Observer gardener = new Gardener(subject);

        subject.setState("rest");
        subject.setState("work");

    }
}