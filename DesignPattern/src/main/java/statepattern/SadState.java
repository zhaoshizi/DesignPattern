package statepattern;

public class SadState implements State{
    public String state = null;
    public void doAction(People people){
        this.state = "sad";
        people.setState(this);
        System.out.println("trun to sad.");
    }

    public String toString(){
        return "I am " + this.state;
    }


}