package JAVACOLLECTION;

import java.util.*;

// ---- Account ----
class Account {
    int id;
    double balance;

    Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Account) && this.id == ((Account)o).id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Acc{" + id + ", bal=" + balance + "}";
    }
}

// ---- Transaction ----
class Transaction {
    Account from, to;
    double amount;

    Transaction(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Txn{" + from.id + " -> " + to.id + " : " + amount + "}";
    }
}

// ---- Banking System ----
public class BankingSystemShort {

    List<Transaction> allTxns = new ArrayList<>();            // record
    Queue<Transaction> pending = new LinkedList<>();          // pending
    Set<Account> validAccounts = new HashSet<>();             // valid accounts
    Stack<Transaction> history = new Stack<>();               // for rollback

    // add valid accounts
    void addAccount(Account a) {
        validAccounts.add(a);
    }

    // 1. Add transaction to queue
    void addTransaction(Transaction t) {
        pending.add(t);
        System.out.println("Added: " + t);
    }

    // 2,3. Validate & execute next transaction
    void executeNext() {
        if (pending.isEmpty()) {
            System.out.println("No pending transactions.");
            return;
        }
        Transaction t = pending.poll();

        if (!validAccounts.contains(t.from) || !validAccounts.contains(t.to)) {
            System.out.println("Invalid account in: " + t);
            return;
        }

        // simple execution (no overdraft check)
        t.from.balance -= t.amount;
        t.to.balance += t.amount;

        allTxns.add(t);
        history.push(t);

        System.out.println("Executed: " + t);
    }

    // 4. Roll back last transaction
    void rollbackLast() {
        if (history.isEmpty()) {
            System.out.println("Nothing to rollback.");
            return;
        }
        Transaction t = history.pop();

        // reverse the transaction
        t.from.balance += t.amount;
        t.to.balance -= t.amount;

        System.out.println("Rolled back: " + t);
    }

    // ---- Demo ----
    public static void main(String[] args) {
        BankingSystemShort bank = new BankingSystemShort();

        Account a1 = new Account(1, 1000);
        Account a2 = new Account(2, 2000);
        Account a3 = new Account(3, 3000);

        bank.addAccount(a1);
        bank.addAccount(a2);
        // a3 NOT added to validAccounts (to show invalid case)

        bank.addTransaction(new Transaction(a1, a2, 200)); // valid
        bank.addTransaction(new Transaction(a2, a3, 500)); // invalid (a3 not valid)

        bank.executeNext(); // executes first
        bank.executeNext(); // fails validation

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        bank.rollbackLast(); // rollback last successful
        System.out.println("After rollback:");
        System.out.println(a1);
        System.out.println(a2);
    }
}

