package statepattern;

public class People{
    private State state = null;

    public State getState(){
        return state;
    }

    public void setState(State state){
        this.state = state;
    }
}