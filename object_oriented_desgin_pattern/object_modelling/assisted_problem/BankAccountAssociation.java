import java.util.ArrayList;

// Account class representing a bank account
class Account {
    private String accountNumber;
    private double balance;
    private Bank bank; // Association with Bank

    // Constructor to initialize account details
    public Account(String accountNumber, double balance, Bank bank) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }

    // Method to get associated bank
    public Bank getBank() {
        return bank;
    }

    // Overriding toString method to display account details
    @Override
    public String toString() {
        return "Account{Account Number='" + accountNumber + "', Balance=" + balance + ", Bank='" + bank.getBankName()
                + "'}";
    }
}

// Customer class representing a bank customer
class Customer {
    private String name;
    private ArrayList<Account> accounts; // List of accounts owned by the customer

    // Constructor to initialize customer details
    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>(); // Initializing the account list
    }

    // Method to add an account to the customer's list of accounts
    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to display customer name and all their accounts
    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}

// Bank class representing a bank with customers
class Bank {
    private String bankName;
    private ArrayList<Customer> customers; // List of customers associated with the bank

    // Constructor to initialize bank details
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>(); // Initializing the customer list
    }

    // Method to get the name of the bank
    public String getBankName() {
        return bankName;
    }

    // Method to open a new account for a customer
    public void openAccount(Customer customer, String accountNumber, double initialBalance) {
        Account account = new Account(accountNumber, initialBalance, this); // Creating a new account
        customer.addAccount(account); // Adding the account to the customer
        if (!customers.contains(customer)) {
            customers.add(customer); // Adding customer to the bank's customer list if not already present
        }
    }

    // Method to display all customers of the bank and their accounts
    public void showCustomers() {
        System.out.println("Bank: " + bankName);
        for (Customer customer : customers) {
            customer.viewBalance();
            System.out.println(); // Adding a blank line for readability
        }
    }
}

public class BankAccountAssociation {
    public static void main(String[] args) {
        // Creating a bank instance
        Bank bank = new Bank("SBI Bank");

        // Creating customer instances
        Customer customer1 = new Customer("John Doe");
        Customer customer2 = new Customer("Jane Smith");

        // Opening accounts for customers with initial balances
        bank.openAccount(customer1, "12345", 5000.0);
        bank.openAccount(customer1, "67890", 3000.0);
        bank.openAccount(customer2, "11223", 10000.0);

        // Displaying all customers and their accounts in the bank
        bank.showCustomers();
    }
}
