package Level_2;

// BankAccount class to store account details and perform transactions
class BankAccount {
    // Attributes for account details
    String accountHolder;
    int accountNumber;
    double balance;

    // Constructor to initialize account details
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        this.balance += amount; // Adding amount to the balance
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (this.balance >= amount) { // Check if sufficient balance exists
            this.balance -= amount; // Deduct the amount
        } else {
            System.out.println("Insufficient Balance"); // Display message if not enough funds
        }
    }

    // Method to display account details
    public void display() {
        System.out.println("\n===== Account Details =====");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Main class to simulate ATM transactions
public class ATM {
    public static void main(String[] args) {
        // Creating two bank accounts
        BankAccount a1 = new BankAccount("Daman", 101, 6000);
        BankAccount a2 = new BankAccount("Abhay", 102, 5000);

        // Display initial account details
        a1.display();

        // Depositing money into a1's account
        a1.deposit(6000);
        a1.display(); // Display updated balance

        // Withdrawing money from a1's account
        a1.withdraw(5000);
        a1.display(); // Display updated balance

        // Display initial details for a2
        a2.display();

        // Withdrawing full balance from a2's account
        a2.withdraw(5000);
        a2.display(); // Display updated balance

        // Depositing a large amount into a2's account
        a2.deposit(327948);
        a2.display(); // Display updated balance
    }
}
