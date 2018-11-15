package interpreterpattern;

public class AndExpression implements Expression{

    Expression exp1 = null;
    Expression exp2 = null;
    public AndExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public boolean interpret(String context){
        return exp1.interpret(context) && exp2.interpret(context);
    }

}