package observerpattern;

public class Farmer extends Observer{
    public Farmer(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update(String state){
        if (state.equals("work")){
            System.out.println("I am farming.");
        }
        else{
            System.out.println("I am eating.");
        }
    }
}