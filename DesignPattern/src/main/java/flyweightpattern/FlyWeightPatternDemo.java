package flyweightpattern;


public class FlyWeightPatternDemo{
    private static final String works[] = 
      { "Paint", "Write", "Read", "Lift", "Cut" };

    public static void main(String args[]){

        for(int i=0;i<20;i++){
            Worker worker = WorkerFactory.getWorker(works[(int)(Math.random()*works.length)]);
            worker.todo("Master" + i);
        }
    }
}