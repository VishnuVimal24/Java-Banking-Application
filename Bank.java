import java.util.*;

abstract class Bank {
    protected String bankName, branchName, bankCode;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    private static int bankCounter = 1;
    protected List<Account> accounts = new ArrayList<>();

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
        this.bankCode = BANK_CODE_PREFIX + String.format("%03d", bankCounter++);
    }

    public abstract void openAccount(Account account);

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void displayBankInfo() {
        System.out.println("\n--- Bank Information ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + bankCode);

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\n--- Account Details ---");
            for (Account acc : accounts) {
                acc.showAccountType();
                System.out.println("Account Holder: " + acc.holderName);
                System.out.println("Account Number: " + acc.accountNumber);
                System.out.println("Balance: ₹" + acc.getBalance());
                System.out.println("---------------------------");
            }
        }
    }
}