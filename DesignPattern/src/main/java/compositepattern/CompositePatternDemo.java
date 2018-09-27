// 组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当作一个单一的对象。
// 组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。
// 种模式创建了一个包含自己对象组的类。该类提供了修改相同对象组的方式。

package compositepattern;

public class CompositePatternDemo{
    public static void main(String arvg[]){
        Worker boss = new Worker("Boss",9);

        Worker master1 = new Worker("Master1",6);
        Worker master2 = new Worker("Master2",3);

        Worker disciple1 = new Worker("Disciple1",1);
        Worker disciple2 = new Worker("Disciple2",2);
        Worker disciple3 = new Worker("Disciple3",0);

        boss.addDisciple(master1);
        boss.addDisciple(master2);

        master1.addDisciple(disciple1);
        master1.addDisciple(disciple2);
        master2.addDisciple(disciple3);

        boss.descAll();
    }
}