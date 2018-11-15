package observerpattern;

public class ObserverPatternDemo{
    public static void main(String args[]){
        Subject subject = new Subject("work");
        Observer farmer = new Farmer(subject);
        Observer worker = new Worker(subject);
        Observer gardener = new Gardener(subject);

        subject.setState("rest");
        subject.setState("work");

    }
}