import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolder, int accountNumber) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: ₹" + amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    public void showTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println("- " + transaction);
            }
        }
    }

    public void showAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        showBalance();
    }
}

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        System.out.print("Enter account number: ");
        int accNum = scanner.nextInt();

        Account userAccount = new Account(name, accNum);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ₹");
                    double depositAmt = scanner.nextDouble();
                    userAccount.deposit(depositAmt);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ₹");
                    double withdrawAmt = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmt);
                    break;
                case 3:
                    userAccount.showBalance();
                    break;
                case 4:
                    userAccount.showTransactionHistory();
                    break;
                case 5:
                    userAccount.showAccountDetails();
                    break;
                case 6:
                    System.out.println("Thank you for using the bank app!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
