package mediatorpattern;

public class Saver implements People{
    public String name = null;
    public Bank bank = null;
    public Saver(String name){
        this.name = name;
    }
    public void setBank(Bank bank){
        this.bank = bank;
    }
    public double saveMoney(double money){
        return bank.borrowMoney(name,money);
    }
    public double borrowMoney(double money){
        return 0;
    }
}