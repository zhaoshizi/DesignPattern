package strategypattern;

public class StrategySubstract implements Strategy{
    public long operation(long a,long b){
        return a-b;
    }
}