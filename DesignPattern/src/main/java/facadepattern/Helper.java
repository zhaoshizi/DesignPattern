package facadepattern;

public class Helper{
    
    public Bank bank;
    public Securities securities;
    public Futures futures;
    public String id;
    public Helper(String id,String bankName,String securitiesName,String futuresName){
        this.bank= new Bank(bankName);
        this.securities = new Securities(securitiesName);
        this.futures = new Futures(futuresName);
        this.id = id;
    }

    public double getAsset(){
        return bank.getAsset(id)+securities.getSecuities(id)+futures.getFutures(id);
    }
}