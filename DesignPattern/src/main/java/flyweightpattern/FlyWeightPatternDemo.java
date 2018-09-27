// 享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。
// 这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。
// 应用实例： 1、JAVA 中的 String，如果有则返回，如果没有则创建一个字符串保存在字符串缓存池里面。 2、数据库的数据池。
package flyweightpattern;


public class FlyWeightPatternDemo{
    private static final String works[] = 
      { "Paint", "Write", "Read", "Lift", "Cut" };

    public static void main(String args[]){

        for(int i=0;i<20;i++){
            Worker worker = WorkerFactory.getWorker(works[(int)(Math.random()*works.length)]);
            worker.todo("Master" + i);
        }
    }
}