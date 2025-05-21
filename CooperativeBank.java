class CooperativeBank extends Bank {
    public CooperativeBank(String name, String branch) {
        super(name, branch);
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Cooperative Bank. Account No: " + account.accountNumber);
    }
}