package Jan31;

public class BankAccount {
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: $" + balance;
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(int accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayAccountInfo() {
        System.out.println("Savings Account Number: " + accountNumber + ", Account Holder: " + accountHolder);
    }

    public static void main(String[] args) {
        SavingsAccount savings1 = new SavingsAccount(12345, "John Doe", 5000);
        savings1.displayAccountInfo();
        System.out.println(savings1);
        savings1.deposit(1000);
        System.out.println("After deposit: " + savings1);
        savings1.withdraw(2000);
        System.out.println("After withdrawal: " + savings1);
    }
}
