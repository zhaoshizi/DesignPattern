package interpreterpattern;

public class InterpreterPatternDemo{
    public static void main(String avgs[]){
        Expression termianl_java = new  TerminalExpression("java");
        Expression termianl_love = new  TerminalExpression("love");
        String love_java = "love_java";
        String hate_java = "hate_java";
        Expression orExpression = new OrExpression(termianl_java, termianl_love);
        Expression andExpression = new AndExpression(termianl_java, termianl_love);
        if (termianl_java.interpret(love_java)){
            System.out.println(love_java + " contains \"java\"");
        }
        if (orExpression.interpret(hate_java)){
            System.out.println(hate_java + " contains \"java\" or \"love\"");
        }
        if (andExpression.interpret(love_java)){
            System.out.println(love_java + " contains \"java\" and \"love\"");
        }

    }
}