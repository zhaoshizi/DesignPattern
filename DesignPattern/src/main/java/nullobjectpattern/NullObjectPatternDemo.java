//在空对象模式（Null Object Pattern）中，一个空对象取代 NULL 对象实例的检查。
//Null 对象不是检查空值，而是反应一个不做任何动作的关系。
//这样的 Null 对象也可以在数据不可用的时候提供默认的行为。
package nullobjectpattern;

public class NullObjectPatternDemo{
    public static void main(String[] args){
        AbstractTriangle triangle1 = TriangleFactory.getTriangle(1,1,1);
        AbstractTriangle triangle2 = TriangleFactory.getTriangle(1,2,3);
        AbstractTriangle triangle3 = TriangleFactory.getTriangle(4,5,3);
        System.out.println(triangle1.discribeTriangle());
        System.out.println(triangle2.discribeTriangle());
        System.out.println(triangle3.discribeTriangle());
 
    }
}