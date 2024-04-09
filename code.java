package Codsoft_Internship;

import java.util.Scanner;

class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public void deposit(double amount) {
     balance += amount;
     System.out.println("Deposit successful. Current balance: " + balance);
 }
 
 public void withdraw(double amount) {
     if (amount <= balance) {
         balance -= amount;
         System.out.println("Withdrawal successful. Current balance: " + balance);
     } else {
         System.out.println("Insufficient funds. Withdrawal failed.");
     }
 }

 public void checkBalance() {
     System.out.println("Current balance: " + balance);
 }
}

public class ATM {
 private BankAccount account;

 public ATM(BankAccount account) {
     this.account = account;
 }

 public void displayMenu() {
     System.out.println("Welcome to the ATM");
     System.out.println("1. Withdraw");
     System.out.println("2. Deposit");
     System.out.println("3. Check Balance");
     System.out.println("4. Exit");
 }
 
 public void perform(int choice) {
     Scanner obj = new Scanner(System.in);
     switch (choice) {
         case 1:
             System.out.print("Enter withdrawal amount: ");
             double withdrawAmount = obj.nextDouble();
             account.withdraw(withdrawAmount);
             break;
         case 2:
             System.out.print("Enter deposit amount: ");
             double depositAmount = obj.nextDouble();
             account.deposit(depositAmount);
             break;
         case 3:
             account.checkBalance();
             break;
         case 4:
             System.out.println("Thank you for using the ATM. Visit Again!");
             System.exit(0);
             break;
         default:
             System.out.println("Invalid choice. Please select again.");
     }
 }

 public static void main(String[] args) {
     BankAccount userAccount = new BankAccount(2500); 
     ATM atm = new ATM(userAccount);
     Scanner obj = new Scanner(System.in);

     while (true) {
         atm.displayMenu();
         System.out.print("Enter your choice: ");
         int choice = obj.nextInt();
         atm.perform(choice);
     }
 }
}
