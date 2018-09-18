package builderpattern;

public abstract class Burge implements Item{
    public Packing packing(){
        return new Wrapper();
    } 
    public abstract float price();
}