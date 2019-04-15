package strategypattern;

public class  StrategyMultiply implements Strategy{
    public long operation(long a,long b){
        return a * b;
    }
}