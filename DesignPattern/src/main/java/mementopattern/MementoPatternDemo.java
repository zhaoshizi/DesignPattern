//所谓备忘录模式就是在不破坏封装的前提下，
//捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态
//使用场景： 1、需要保存/恢复数据的相关状态场景。 2、提供一个可回滚的操作。
package mementopattern;

public class MementoPatternDemo{

    public static void main(String args[]){
        Player player = new Player("state1");
        Saver saver = new Saver();

        player.setState("state2");
        saver.addRecord(player.saveRecord());

        player.setState("state3");
        saver.addRecord(player.saveRecord());

        player.setState("state4");
        System.out.println(player.getState());

        player.getRecord(saver.getRecord(0));
        System.out.println(player.getState());

        player.getRecord(saver.getRecord(1));
        System.out.println(player.getState());

    }

}