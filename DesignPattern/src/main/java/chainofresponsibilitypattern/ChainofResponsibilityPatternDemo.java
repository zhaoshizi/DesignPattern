// 顾名思义，责任链模式（Chain of Responsibility Pattern）为请求创建了一个接收者对象的链。这种模式给予请求的类型，
// 对请求的发送者和接收者进行解耦。这种类型的设计模式属于行为型模式。

// 在这种模式中，通常每个接收者都包含对另一个接收者的引用。如果一个对象不能处理该请求，
// 那么它会把相同的请求传给下一个接收者，依此类推。

package chainofresponsibilitypattern;

public class ChainofResponsibilityPatternDemo{

    public static WorkStep getWorkFlow(){
        WorkStepOne workStepOne = new WorkStepOne(WorkStep.workflow1);
        WorkStepTwo workStepTwo = new WorkStepTwo(WorkStep.workflow2);
        WorkStepThree workStepThree = new WorkStepThree(WorkStep.workflow1);

        workStepOne.setNextWorkStep(workStepTwo);
        workStepTwo.setNextWorkStep(workStepThree);

        return workStepOne;
    }
    public static void main(String args[]){
        
        WorkStep workflow = getWorkFlow();

        workflow.process(1);
        workflow.process(2);
        

    }


}