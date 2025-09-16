package EncapsulAbsJAVA;

import java.util.*;

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Encapsulation: Getters & Setters
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " deposited. New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal.");
        }
    }

    // Abstract Method
    public abstract double calculateInterest();

    // Display details
    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.04; // 4% interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Application: Amount " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000; // eligible if balance > 5000
    }
}

// Current Account
class CurrentAccount extends BankAccount {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.02; // 2% interest
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SAV123", "Alice", 10000));
        accounts.add(new CurrentAccount("CUR456", "Bob", 20000));

        for (BankAccount acc : accounts) {
            acc.displayAccountDetails();
            double interest = acc.calculateInterest();
            System.out.println("Interest: " + interest);

            // Loan functionality if applicable
            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(50000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }

            System.out.println("-----");
        }
    }
}

