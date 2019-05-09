//在模板模式（Template Pattern）中，一个抽象类公开定义了执行它的方法的方式/模板。
//它的子类可以按需要重写方法实现，但调用将以抽象类中定义的方式进行。这种类型的设计模式属于行为型模式。
//为防止恶意操作，一般模板方法都加上 final 关键词。
package templatepattern;

public class TemplatePatternDemo{
    public static void main(String[] args) {
        Restaurant hotpotRestaurant = new HotpotRestaurant();
        hotpotRestaurant.run();

        Restaurant sushiRestaurant = new SushiRestaurant();
        sushiRestaurant.run(); 
    }
}