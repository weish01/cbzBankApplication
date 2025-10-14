package com.CBZ.BANK;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static double balance = 1500.0;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== WELCOME TO SECUREBANK APP ===");
        System.out.println("Default Login: cinderella / h240404A");

        while (running) {
            System.out.println("\n=== SECUREBANK.APP ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    loginUser();
                    break;
                case "2":
                    registerUser();
                    break;
                case "3":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
        sc.close();
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (username.equals("cinderella") && password.equals("h240404A")) {
            System.out.println("✓ Login successful! Welcome, " + username + "!");
            showBankingMenu();
        } else {
            System.out.println("✗ Invalid username or password!");
        }
    }

    private static void registerUser() {
        System.out.println("\n=== REGISTRATION ===");
        System.out.print("Enter new username: ");
        String username = sc.nextLine();
        System.out.print("Enter new password: ");
        String password = sc.nextLine();

        System.out.println("✓ Registration successful! You can now login with: " + username);
    }

    private static void showBankingMenu() {
        boolean inBankingMenu = true;

        while (inBankingMenu) {
            System.out.println("\n=== BANKING OPERATIONS ===");
            System.out.println("1. View Profile");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transaction History");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    viewUserProfile();
                    break;
                case "2":
                    checkBalance();
                    break;
                case "3":
                    depositMoney();
                    break;
                case "4":
                    withdrawMoney();
                    break;
                case "5":
                    showTransactionHistory();
                    break;
                case "6":
                    System.out.println("✓ Logging out...");
                    inBankingMenu = false;
                    break;
                default:
                    System.out.println("✗ Invalid choice. Try again.");
            }
        }
    }

    private static void viewUserProfile() {
        System.out.println("\n=== USER PROFILE ===");
        System.out.println("Username: cinderella");
        System.out.println("Full Name: Sindisiwe Letter");
        System.out.println("Email: lettercindy@gmail.com");
        System.out.println("Phone: 0779995522");
        System.out.println("Account Type: Savings Account");
        System.out.println("Account Status: Active");
        System.out.println("Member Since: January 2024");
        System.out.println("===========================");
    }

    private static void checkBalance() {
        System.out.println("\n=== ACCOUNT BALANCE ===");
        System.out.printf("Current Balance: $%.2f%n", balance);
        System.out.println("=======================");
    }

    private static void depositMoney() {
        System.out.print("Enter amount to deposit: $");
        try {
            double amount = Double.parseDouble(sc.nextLine());
            if (amount > 0) {
                balance += amount;
                System.out.printf("✓ Deposited: $%.2f%n", amount);
                System.out.printf("New Balance: $%.2f%n", balance);
            } else {
                System.out.println("✗ Invalid amount!");
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: $");
        try {
            double amount = Double.parseDouble(sc.nextLine());
            if (amount > 0) {
                if (amount <= balance) {
                    balance -= amount;
                    System.out.printf("✓ Withdrew: $%.2f%n", amount);
                    System.out.printf("New Balance: $%.2f%n", balance);
                } else {
                    System.out.println("✗ Insufficient funds!");
                    System.out.printf("Current Balance: $%.2f%n", balance);
                }
            } else {
                System.out.println("✗ Invalid amount!");
            }
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input!");
        }
    }

    private static void showTransactionHistory() {
        System.out.println("\n=== TRANSACTION HISTORY ===");
        System.out.println("1. Account Created - Initial Balance: $1500.00");
        System.out.println("2. Balance Check - Current System");
        System.out.println("===========================");
    }
}
