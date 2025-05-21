import java.util.*;

public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = null;

        int bankType = 0;
        while (bankType != 1 && bankType != 2) {
            System.out.println("Choose Bank Type:\n1. Nationalized Bank\n2. Cooperative Bank");
            if (sc.hasNextInt()) {
                bankType = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                System.out.println("Please enter a number (1 or 2).");
            }
        }

        System.out.print("Enter Bank Name: ");
        String bankName = sc.nextLine();

        System.out.print("Enter Branch Name: ");
        String branchName = sc.nextLine();

        if (bankType == 1) {
            bank = new NationalizedBank(bankName, branchName);
        } else {
            bank = new CooperativeBank(bankName, branchName);
        }

        boolean addMoreAccounts = true;
        while (addMoreAccounts) {
            System.out.println("\nChoose Account Type:\n1. Savings\n2. Current\n3. Loan");
            int accType = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Account Holder Name: ");
            String holder = sc.nextLine();

            System.out.print("Enter Initial Amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            String accountNumber = String.valueOf((int)(Math.random() * 9000 + 1000));
            Account account = null;

            if (accType == 1) {
                account = new SavingsAccount(accountNumber, holder, amount);
            } else if (accType == 2) {
                account = new CurrentAccount(accountNumber, holder, amount);
            } else if (accType == 3) {
                account = new LoanAccount(accountNumber, holder, amount);
            }

            bank.openAccount(account);

            System.out.print("Do you want to add another account? (yes/no): ");
            String more = sc.nextLine().toLowerCase();
            addMoreAccounts = more.equals("yes");
        }

        boolean run = true;
        while (run) {
            System.out.println("\nChoose an Operation:\n1. Deposit\n2. Withdraw\n3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.nextLine();

                System.out.print("Enter Deposit Amount: ");
                double depAmt = sc.nextDouble();
                sc.nextLine();

                Account acc = bank.findAccount(accNo);
                if (acc != null) {
                    acc.deposit(depAmt);
                    System.out.println("Deposit successful. Current Balance: ₹" + acc.getBalance());
                } else {
                    System.out.println("Account not found.");
                }
            } else if (choice == 2) {
                System.out.print("Enter Account Number: ");
                String accNo = sc.nextLine();

                System.out.print("Enter Withdrawal Amount: ");
                double withAmt = sc.nextDouble();
                sc.nextLine();

                Account acc = bank.findAccount(accNo);
                if (acc != null) {
                    if (acc instanceof LoanAccount) {
                        System.out.println("Withdrawal not allowed from a Loan Account.");
                    } else {
                        acc.withdraw(withAmt);
                        System.out.println("Withdrawal attempted. Current Balance: ₹" + acc.getBalance());
                    }
                } else {
                    System.out.println("Account not found.");
                }
            } else {
                run = false;
                System.out.println("Exiting operations. Thank you for using our banking system!");
            }
        }

        bank.displayBankInfo();
        sc.close();
    }
}