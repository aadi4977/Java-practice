package JAVAMAP.java;

import java.util.*;

public class BankingSystem {
    private static Map<String, Double> accounts = new HashMap<>();

    // 1. Add new account
    static void addAccount(String accNo, double balance) {
        accounts.put(accNo, balance);
    }

    // 2. Deposit
    static void deposit(String accNo, double amount) {
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found: " + accNo);
            return;
        }
        accounts.put(accNo, accounts.get(accNo) + amount);
    }

    // 2. Withdraw with balance check
    static void withdraw(String accNo, double amount) {
        if (!accounts.containsKey(accNo)) {
            System.out.println("Account not found: " + accNo);
            return;
        }
        double bal = accounts.get(accNo);
        if (amount > bal) {
            System.out.println("Insufficient balance for " + accNo);
        } else {
            accounts.put(accNo, bal - amount);
        }
    }

    // 3. Print all customers sorted by descending balance
    static void printSortedByBalance() {
        System.out.println("\nAccounts sorted by balance (high → low):");
        accounts.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .forEach(e ->
                        System.out.println(e.getKey() + " : " + e.getValue()));
    }

    // 4. Top 3 customers
    static void printTop3() {
        System.out.println("\nTop 3 customers:");
        accounts.entrySet().stream()
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .limit(3)
                .forEach(e ->
                        System.out.println(e.getKey() + " : " + e.getValue()));
    }

    public static void main(String[] args) {
        // Add accounts
        addAccount("ACC101", 50000);
        addAccount("ACC102", 75000);
        addAccount("ACC103", 30000);
        addAccount("ACC104", 90000);
        addAccount("ACC105", 45000);
        addAccount("ACC106", 80000);

        // Some operations
        deposit("ACC101", 10000);
        withdraw("ACC103", 35000); // should show insufficient
        withdraw("ACC103", 5000);  // valid
        deposit("ACC104", 5000);

        printSortedByBalance();
        printTop3();
    }
}

