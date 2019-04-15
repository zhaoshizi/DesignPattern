package strategypattern;

public class Clac{
    private Strategy strategy;
    public Clac(Strategy strategy){
        this.strategy = strategy;
    }

    public long operate(long a,long b){
        return strategy.operation(a, b);
    }
}