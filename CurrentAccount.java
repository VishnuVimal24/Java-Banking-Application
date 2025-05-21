class CurrentAccount extends Account {
    public CurrentAccount(String accNo, String holder, double amount) {
        super(accNo, holder, amount);
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Not enough balance.");
        }
    }

    public void showAccountType() {
        System.out.println("Account Type: Current");
    }
}