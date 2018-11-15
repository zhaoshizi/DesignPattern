package mediatorpattern;

public class ABCBank implements Bank{
    public String name = null;
    public ABCBank(String name){
        this.name = name;
    }

    public double borrowMoney(String name,double money){
        System.out.println(name + " save money: " + money);
        return money;
    }

    public double lendMoney(String name,double money){
        System.out.println(name + " borrow money: " + money);
        return money;
    }
}