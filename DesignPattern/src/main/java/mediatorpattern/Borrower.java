package mediatorpattern;

public class Borrower implements People{
    public String name = null;
    public Bank bank = null;
    public Borrower(String name){
        this.name = name;
    }
    public void setBank(Bank bank){
        this.bank = bank;
    }
    public double saveMoney(double money){
        return 0;
    }
    public double borrowMoney(double money){
        return bank.lendMoney(name,money);
    }
}