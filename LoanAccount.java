class LoanAccount extends Account {
    public LoanAccount(String accNo, String holder, double amount) {
        super(accNo, holder, amount);
    }

    public void deposit(double amount) {
        balance -= amount; // Paying off the loan
    }

    public void withdraw(double amount) {
        System.out.println("Cannot withdraw from Loan Account.");
    }

    public void showAccountType() {
        System.out.println("Account Type: Loan");
    }
}