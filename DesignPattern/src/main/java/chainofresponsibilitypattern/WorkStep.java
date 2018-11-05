package chainofresponsibilitypattern;

public abstract class WorkStep{
    public static int workflow1 = 1;
    public static int workflow2 = 2;

    public int workflow = 0;
    private WorkStep nextWorkStep;

    public void setNextWorkStep(WorkStep workStep){
        this.nextWorkStep = workStep;
    }

    public void process(int workflow){
        if (this.workflow == workflow){
            this.work();
            if (nextWorkStep != null)
                nextWorkStep.process(workflow);
        }
        else{
            if (nextWorkStep != null)
                nextWorkStep.process(workflow);
        }

    }

    abstract public void work();
}