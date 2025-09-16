package JAVACLASSANDOBJ.LVL2;


class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMTest {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Aarav Sharma", "1234567890", 10000);

        acc1.displayBalance();
        System.out.println("------------------");

        acc1.deposit(5000);
        acc1.displayBalance();
        System.out.println("------------------");

        acc1.withdraw(3000);
        acc1.displayBalance();
        System.out.println("------------------");

        acc1.withdraw(15000);
        acc1.displayBalance();
    }
}
