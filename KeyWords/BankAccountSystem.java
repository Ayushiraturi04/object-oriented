// Create a BankAccount class with the following features:

public class BankAccountSystem {
    public static void main(String[] args) {
        // Creating three bank accounts with different details
        BankAccount account1 = new BankAccount("John Doe", 123456, 1000);
        BankAccount account2 = new BankAccount("Jane Doe", 654321, 2000);
        BankAccount account3 = new BankAccount("John Smith", 987654, 3000);

        // Display total number of bank accounts created
        BankAccount.getTotalAccounts();

        // Display details of each account
        account1.displayAccountDetails();
        account2.displayAccountDetails();
        account3.displayAccountDetails();
    }
}

// BankAccount class representing a bank account
class BankAccount {
    // Static variable shared among all instances, representing the bank name
    private static String bankName = "Bank of Java";
    
    // Static variable to keep track of total accounts created
    private static int totalAccounts = 0;
    
    // Final variable to ensure the account number cannot be changed once assigned
    private final int accountNumber;
    
    // Instance variables for account holder's name and balance
    private String accountHolderName;
    private double balance;

    // Constructor to initialize a new bank account
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName; // Using 'this' to refer to instance variable
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++; // Increment total accounts whenever a new account is created
    }

    // Method to display account details
    public void displayAccountDetails() {
        // Checking if the object is an instance of BankAccount (not necessary here, but included as per instruction)
        if (this instanceof BankAccount) {
            System.out.println("Bank Name: " + bankName);
            System.out.println("Account Holder Name: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
            System.out.println();
        }
    }

    // Static method to display the total number of bank accounts created
    public static void getTotalAccounts() {
        System.out.println("Total Accounts: " + totalAccounts);
    }
}




// Static:
// A static variable bankName shared across all accounts.
// A static method getTotalAccounts() to display the total number of accounts.
// This:
// Use this to resolve ambiguity in the constructor when initializing accountHolderName and accountNumber.
// Final:
// Use a final variable accountNumber to ensure it cannot be changed once assigned.
// Instanceof:
// Check if an account object is an instance of the BankAccount class before displaying its details.
