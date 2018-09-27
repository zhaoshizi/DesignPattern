package flyweightpattern;

public class Worker implements Peaple{
    public String work;
    public Worker(String work){
        this.work = work;
    }

    public void todo(String masterName){
        System.out.println("do " + work + " for " + masterName); 
    }
}