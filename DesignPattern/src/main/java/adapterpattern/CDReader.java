package adapterpattern;

public class CDReader implements MediaReader{
    public void readCard(String ID){

    }

    public void readCD(String ID){
        System.out.println("Read CD:" +ID);
    }
}