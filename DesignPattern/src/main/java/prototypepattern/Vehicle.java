package prototypepattern;

public abstract class Vehicle implements Cloneable{
    protected String type;
    private String name;

    abstract void run();

    public void setType(String type){
        this.type = type;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public Object clone(){
        Object clone = null;
        try{
            clone = super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return clone;
    }
}