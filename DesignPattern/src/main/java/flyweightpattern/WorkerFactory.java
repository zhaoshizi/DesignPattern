package flyweightpattern;

import java.util.HashMap;

public class WorkerFactory{
    private static final HashMap<String,Worker> hashmap= new HashMap<String, Worker>();

    public static Worker getWorker(String work){
        Worker worker = hashmap.get(work);

        if (worker == null){
            worker = new Worker(work);
            hashmap.put(work,worker);
        }
        return worker;
    }
}