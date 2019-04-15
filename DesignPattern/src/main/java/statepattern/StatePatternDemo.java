// 在状态模式（State Pattern）中，类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
// 在状态模式中，我们创建表示各种状态的对象和一个行为随着状态对象改变而改变的 context 对象。
//应用实例： 1、打篮球的时候运动员可以有正常状态、不正常状态和超常状态。 
//2、曾侯乙编钟中，'钟是抽象接口','钟A'等是具体状态，'曾侯乙编钟'是具体环境（Context）。
package statepattern;

public class StatePatternDemo{
    public static void main(String[] args){
        People people = new People();
        
        SadState sadState = new SadState();
        sadState.doAction(people);
        System.out.println(people.getState().toString());

        HappyState happyState = new HappyState();
        happyState.doAction(people);
        System.out.println(people.getState().toString());
    }
}