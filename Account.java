abstract class Account implements AccountOperations {
    protected String accountNumber, holderName;
    protected double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public abstract void showAccountType();
}