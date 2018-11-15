package mementopattern;

public class Player{
    String state = null;
    public Player(String state){
        this.state = state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
    public Record saveRecord(){
        return new Record(this.state);
    }

    public void getRecord(Record record){
        this.state = record.getState();
    }
}