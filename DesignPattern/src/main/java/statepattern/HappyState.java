package statepattern;

public class HappyState implements State{
    public String state = null;
    public void doAction(People people){
        this.state = "happy";
        people.setState(this);
        System.out.println("trun to happy.");
    }

    public String toString(){
        return "I am " + this.state;
    }


}