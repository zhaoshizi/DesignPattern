package mediatorpattern;

public interface Bank{
    public double borrowMoney(String name,double money);
    public double lendMoney(String name,double money);
}