package templatepattern;

public abstract class Restaurant{
    public abstract void open();
    public abstract void makeFood();
    public abstract void close();

    public final void run(){
        open();
        makeFood();
        close();
    }
}