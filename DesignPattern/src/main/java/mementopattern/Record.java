package mementopattern;

public class Record{
    String state = null;
    public Record(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }
}