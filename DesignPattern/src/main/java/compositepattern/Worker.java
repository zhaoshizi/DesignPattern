package compositepattern;

import java.util.List;
import java.util.ArrayList;

public class Worker{
    String name;
    int level;
    List<Worker> discipleList;

    public Worker(String name,int level){
        this.name = name;
        this.level = level;
        discipleList = new ArrayList<Worker>();
    }

    public void desc(){
        System.out.println("Name: " + name + " Level:" + level);
        for(Worker worker : discipleList){
            worker.desc();
        }
    }

    public void descAll(){
        System.out.println("Name: " + name + " Level:" + level);
        for(Worker worker : discipleList){
            worker.descAll();
        }
    }

    public void addDisciple(Worker disciple){
        discipleList.add(disciple);
    }

}