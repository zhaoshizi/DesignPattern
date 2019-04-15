// 在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
// 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法。
package strategypattern;

public class StrategyPatternDemo{
    public static void main(String[] args){
        long a = 3 ,b = 2;
        Clac clacAdd = new Clac(new StrategyAdd());

        System.out.println("two num: a = " + a + ", b = " + b);
        System.out.println("Add: " + clacAdd.operate(a, b));
        Clac clacSubstract = new Clac(new StrategySubstract());
        System.out.println("Sub: " + clacSubstract.operate(a, b));
        Clac clacMultiply = new Clac(new StrategyMultiply());
        System.out.println("Mul: " + clacMultiply.operate(a, b));
    }
}