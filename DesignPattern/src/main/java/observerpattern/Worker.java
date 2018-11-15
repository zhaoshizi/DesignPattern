package observerpattern;

public class Worker extends Observer{
    public Worker(Subject subject){
        this.subject = subject;
        this.subject.addObserver(this);
    }

    public void update(String state){
        if (state.equals("work")){
            System.out.println("I am working.");
        }
        else{
            System.out.println("I am sleeping.");
        }
    }
}