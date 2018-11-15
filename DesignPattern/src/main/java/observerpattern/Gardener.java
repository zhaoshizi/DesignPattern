package observerpattern;

public class Gardener extends Observer{
    public Gardener(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update(String state){
        if (state.equals("work")){
            System.out.println("I am watering.");
        }
        else{
            System.out.println("I am drinking.");
        }
    }
}