package strategypattern;

public class StrategyAdd implements Strategy{
    public long operation(long a,long b){
        return a+b;
    }
}