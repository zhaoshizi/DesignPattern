//用来降低多个对象和类之间的通信复杂性。
//这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。
//何时使用：多个类相互耦合，形成了网状结构。
//如何解决：将上述网状结构分离为星型结构。
package mediatorpattern;

public class MediatorPatternDemo{
    public static void main(String args[]){
        People tom = new Saver("Tom");
        People jack = new Borrower("Jack");

        Bank abcBank = new ABCBank("ABC");
        tom.setBank(abcBank);
        jack.setBank(abcBank);

        tom.saveMoney(1000);
        jack.borrowMoney(1000);
    }
}