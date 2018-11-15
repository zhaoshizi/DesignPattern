package iteratorpattern;

public class MovieContainer implements Container{
    String MovieList[] = {"阿甘正传","勇敢的心","这个杀手不太冷","楚门的世界"};

    public IteratorInterface getIterator(){
        return new MovieContainerIterator();
    }

    private class MovieContainerIterator implements IteratorInterface{
        public int index = 0;
        public boolean hasNext(){
            if (index < MovieList.length){
                return true;
            }
            return false;
        }
        public Object next(){
            return MovieList[index++];
        }
    }
}