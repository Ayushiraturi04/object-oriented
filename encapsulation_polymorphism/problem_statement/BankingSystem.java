import java.util.ArrayList;
import java.util.List;

// Abstract class representing a Bank Account
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    protected double balance; // Protected to allow access within subclasses

    // Constructor to initialize account details
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters for encapsulation (No direct access to fields)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Concrete method for deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Concrete method for withdrawal
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method to be implemented by subclasses
    public abstract double calculateInterest();

    // Display account details
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}

// Interface representing Loanable accounts
interface Loanable {
    boolean applyForLoan(double amount);

    double calculateLoanEligibility();
}

// Savings Account subclass (Loanable)
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate = 0.04; // 4% annual interest

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Implement interest calculation (4% of balance)
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    // Implement loan eligibility (50% of balance)
    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    @Override
    public double calculateLoanEligibility() {
        return balance * 0.5; // Eligible for 50% of balance
    }
}

// Current Account subclass (Loanable)
class CurrentAccount extends BankAccount implements Loanable {
    private double interestRate = 0.02; // 2% annual interest
    private double overdraftLimit = 1000; // Overdraft allowed

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Implement interest calculation (2% of balance)
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }

    // Implement loan eligibility (Twice the balance + overdraft)
    @Override
    public boolean applyForLoan(double amount) {
        return amount <= calculateLoanEligibility();
    }

    @Override
    public double calculateLoanEligibility() {
        return (balance * 2) + overdraftLimit;
    }
}

// Main class to test the Banking System
public class BankingSystem {
    public static void main(String[] args) {
        // List to store bank accounts using polymorphism
        List<BankAccount> accounts = new ArrayList<>();

        // Creating different account types
        SavingsAccount savings = new SavingsAccount("SA123456", "Alice", 5000);
        CurrentAccount current = new CurrentAccount("CA987654", "Bob", 3000);

        // Adding accounts to the list
        accounts.add(savings);
        accounts.add(current);

        // Processing accounts dynamically
        for (BankAccount account : accounts) {
            account.displayDetails();
            System.out.println("Interest Earned: $" + account.calculateInterest());

            // Checking loan eligibility
            if (account instanceof Loanable) {
                Loanable loanAccount = (Loanable) account;
                double loanAmount = 2000; // Example loan request
                System.out.println("Loan Eligibility: $" + loanAccount.calculateLoanEligibility());
                System.out.println("Loan Approval: " + (loanAccount.applyForLoan(loanAmount) ? "Approved" : "Denied"));
            }

            System.out.println("----------------------------");
        }
    }
}
