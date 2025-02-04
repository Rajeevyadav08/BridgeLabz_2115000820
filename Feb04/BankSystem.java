package Feb04;

import java.util.ArrayList;
import java.util.List;

class BankAccount {
    private String accountNumber;
    private double balance;
    private Bank bank;

    public BankAccount(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void viewBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: " + balance);
    }

    public Bank getBank() {
        return bank;
    }
}

class Customer {
    private String name;
    List<BankAccount> accounts;
    
        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }
    
        public String getName() {
            return name;
        }
    
        public void openAccount(Bank bank, String accountNumber, double initialDeposit) {
            BankAccount newAccount = bank.openAccount(accountNumber, initialDeposit, this);
            accounts.add(newAccount);
            System.out.println(name + " opened a new account with number " + accountNumber + " at " + bank.getBankName());
        }
    
        public void viewAccounts() {
            System.out.println(name + "'s Accounts:");
            for (BankAccount account : accounts) {
                account.viewBalance();
            }
        }
    }
    
    class Bank {
        private String bankName;
        private List<BankAccount> accounts;
    
        public Bank(String bankName) {
            this.bankName = bankName;
            this.accounts = new ArrayList<>();
        }
    
        public String getBankName() {
            return bankName;
        }
    
        public BankAccount openAccount(String accountNumber, double initialDeposit, Customer customer) {
            BankAccount newAccount = new BankAccount(accountNumber, initialDeposit, this);
            accounts.add(newAccount);
            return newAccount;
        }
    
        public void showBankDetails() {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Total Accounts: " + accounts.size());
        }
    }
    
    public class BankSystem {
        public static void main(String[] args) {
            // Creating a bank
            Bank bank = new Bank("XYZ Bank");
    
            // Creating customers
            Customer customer1 = new Customer("Alice");
            Customer customer2 = new Customer("Bob");
    
            // Customers opening accounts
            customer1.openAccount(bank, "12345", 1000.00);
            customer2.openAccount(bank, "67890", 500.00);
    
            // Depositing money into accounts
            customer1.viewAccounts();
            customer1.openAccount(bank, "54321", 2000.00);
            customer1.viewAccounts();
    
            // Withdraw money
            customer1.viewAccounts();
            for (BankAccount account : customer1.accounts) {
            account.withdraw(500);
            account.viewBalance();
        }

        // View Bank Details
        bank.showBankDetails();
    }
}

