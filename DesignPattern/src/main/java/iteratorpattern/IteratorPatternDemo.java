//这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
//定义接口：hasNext, next。
package iteratorpattern;

public class IteratorPatternDemo{

    public static void main(String args[]){
        MovieContainer movieContainer = new MovieContainer();

        IteratorInterface movieIterator = movieContainer.getIterator();
        while(movieIterator.hasNext()){
            System.out.println(movieIterator.next());
        }

    }
}