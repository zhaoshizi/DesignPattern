package observerpattern;

public abstract class Observer{
    public Subject subject;
    public abstract void update(String state);
}