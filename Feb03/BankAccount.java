package Feb03;
import java.util.Scanner;
class BankAccount {
    private static String bankName = "ABC Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;
    public BankAccount(String accountHolderName, int accountNumber, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        totalAccounts++;
    }
    public static int getTotalAccounts() {
        return totalAccounts;
    }
    public void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("\nBank Name: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of accounts to create: ");
        int n = scanner.nextInt();
        BankAccount[] accounts = new BankAccount[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Account " + (i + 1) + ":");
            System.out.print("Enter Account Holder Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.print("Enter Account Number: ");
            int accNumber = scanner.nextInt();
            System.out.print("Enter Initial Balance: ");
            double balance = scanner.nextDouble();
            accounts[i] = new BankAccount(name, accNumber, balance);
        }
        System.out.println("\n--- Account Details ---");
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
        }
        System.out.println("\nTotal Accounts Created: " + BankAccount.getTotalAccounts());
        scanner.close();
    }
}
