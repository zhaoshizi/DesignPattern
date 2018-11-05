package chainofresponsibilitypattern;

public class WorkStepThree extends WorkStep{

    public WorkStepThree(int workflow){
        this.workflow = workflow;
    }

    public void work(){
        System.out.println("WorkStepThree.");
    }
}