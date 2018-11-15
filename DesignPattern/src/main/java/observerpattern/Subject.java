package observerpattern;

import java.util.List;
import java.util.ArrayList;

public class Subject{
    List<Observer> observers = new ArrayList<Observer>();
    public String state = null;

    public Subject(String state){
        this.state = state;
    }

    public void setState(String state){
        this.state = state;
        notifyAllObservers();
    }  

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers){
            observer.update(state);
        }
    }
}