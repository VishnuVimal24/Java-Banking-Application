class NationalizedBank extends Bank {
    public NationalizedBank(String name, String branch) {
        super(name, branch);
    }

    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Nationalized Bank. Account No: " + account.accountNumber);
    }
}