
public class Transaction {
    private double amount;
    private String transactionType;

    Transaction(double amount, String transactionType){
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getTransactionType(){
        return this.transactionType;
    }
}
