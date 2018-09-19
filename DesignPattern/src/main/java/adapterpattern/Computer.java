package adapterpattern;

public class Computer implements Reader{
    MediaAdapter mediaAdapter;

    public void read(String type,String ID){
        if(type.equalsIgnoreCase("SSD")){
            System.out.println("Read SSD:" + ID);
        }
        else if(type.equalsIgnoreCase("Card") || type.equalsIgnoreCase("CD")){
            mediaAdapter = new MediaAdapter();
            mediaAdapter.read(type,ID);
        }
        else{
            System.out.println("Invalid media "+type + " type not supported");
        }
    }
    
}