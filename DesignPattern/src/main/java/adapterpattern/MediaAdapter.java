package adapterpattern;

public class MediaAdapter implements Reader{

    MediaReader  mediaReader;

    public void read(String type,String ID){
        if (type.equalsIgnoreCase("Card")){
            mediaReader = new CardReader();
            mediaReader.readCard(ID);
        }
        else if(type.equalsIgnoreCase("CD")){
            mediaReader = new CDReader();
            mediaReader.readCD(ID);
        }
    }
}