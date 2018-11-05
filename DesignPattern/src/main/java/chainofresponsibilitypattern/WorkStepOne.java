package chainofresponsibilitypattern;

public class WorkStepOne extends WorkStep{
    
    public WorkStepOne(int workflow){
        this.workflow = workflow;
    }

    public void work(){
        System.out.println("WorkStepOne.");
    }
}