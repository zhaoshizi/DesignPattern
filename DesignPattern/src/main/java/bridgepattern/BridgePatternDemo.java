// 将抽象和实现放在两个不同的类层次中，使它们可以独立地变化。——《Head First 设计模式》
// 将类的功能层次结构和实现层次结构相分离，使二者能够独立地变化，并在两者之间搭建桥梁，实现桥接。—— 《图解设计模式》
// 类的功能层次结构：父类具有基本功能，在子类中增加新的功能；
// 类的实现层次结构：父类通过声明抽象方法来定义接口，子类通过实现具体方法来实现接口；
// 桥接模式中有四个角色：
// 抽象化角色(Peaple)：使用实现者角色提供的接口来定义基本功能接口。
//      持有实现者角色，并在功能接口中委托给它，起到搭建桥梁的作用；
//      注意，抽象化角色并不是指它就是一个抽象类，而是指抽象了实现。
// 改善后的抽象化角色(Painter)：作为抽象化角色的子类，增加新的功能，也就是增加新的接口（方法）；与其构成类的功能层次结构；
// 实现者角色(DrawAPI)：提供了用于抽象化角色的接口；它是一个抽象类或者接口。
// 具体的实现者角色(RedDrawAPI)：作为实现者角色的子类，通过实现具体方法来实现接口；与其构成类的实现层次结构。
// 如果抽象和实现两者做不到独立地变化，就不算桥接模式。

package bridgepattern;

public class BridgePatternDemo{
    public static void main(String argv[]){
        DrawAPI redDrawAPI = new RedDrawAPI();
        DrawAPI greenDrawAPI = new GreenDrawAPI();

        Peaple painter1 = new Painter(redDrawAPI);
        Peaple painter2 = new Painter(greenDrawAPI);

        painter1.draw();
        painter2.draw();

    }
}