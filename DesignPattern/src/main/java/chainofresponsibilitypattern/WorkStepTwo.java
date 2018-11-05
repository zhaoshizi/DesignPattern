package chainofresponsibilitypattern;

public class WorkStepTwo extends WorkStep{

    public WorkStepTwo(int workflow){
        this.workflow = workflow;
    }

    public void work(){
        System.out.println("WorkStepTwo.");
    }
}