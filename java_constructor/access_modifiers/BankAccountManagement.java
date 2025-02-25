package access_modifiers;

// Base class: BankAccount
class BankAccount {
    public String accountNumber; // Public: Accessible everywhere
    protected String accountHolder; // Protected: Accessible in subclass
    private double balance; // Private: Only accessible via methods

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Display SavingsAccount details
    public void displaySavingsAccountInfo() {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber); // Public - Accessible
        System.out.println("Account Holder: " + accountHolder); // Protected - Accessible in subclass
        System.out.println("Balance: " + getBalance()); // Access private via getter
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Main class to test
public class BankAccountManagement {
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount acc1 = new BankAccount("123456789", "Alice Johnson", 5000);
        acc1.displayAccountInfo();

        // Performing transactions
        acc1.deposit(1500);
        acc1.withdraw(2000);
        System.out.println("Updated Balance:" + acc1.getBalance());

        // Creating a SavingsAccount object
        SavingsAccount savAcc = new SavingsAccount("987654321", "Bob Smith", 10000, 3.5);
        savAcc.displaySavingsAccountInfo();
    }
}
