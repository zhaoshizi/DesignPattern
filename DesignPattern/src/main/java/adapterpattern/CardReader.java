package adapterpattern;

public class CardReader implements MediaReader{

    public void readCard(String ID){
        System.out.println("Read Card:" + ID);
    }

    public void readCD(String ID){
        
    }
}