
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class SavingAccount extends HeadOffice {

    private double Amount;
    private float interest;
    private String name;
    private double acc_no;
    private double br_code;
    private double pin;
    String path = "C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\savingaccount.txt";

    public double debitAmount() {
        System.out.println("Enter account info:\nTitle_of_Account");
        try {
            name = reader.next();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Account_Number");
        try {
            acc_no = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Branch_Code");
        try {
            br_code = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("PIN");
        try {
            pin = reader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        try {
            readBalance(name, acc_no, br_code, (int) pin, path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Enter Amount to Withdrawl");
        Amount = reader.nextDouble();

        if (balance == -2) {
            return -2;
        } else if (Amount > balance) {
            return -1;
        }

        try {
            updateBalance(name, acc_no, br_code, (int) pin, Amount, '-', path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        balance = balance - Amount;
        return balance;
    }

    public double creditAmount() {
        System.out.println("Enter account info:\nTitle_of_Account");
        try {
            name = reader.next();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Account_Number");
        try {
            acc_no = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Branch_Code");
        try {
            br_code = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("PIN");
        try {
            pin = reader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        try {
            readBalance(name, acc_no, br_code, (int) pin, path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Enter Amount to Deposit");
        Amount = reader.nextDouble();

        if (balance == -2) {
            return -2;
        }

        try {
            updateBalance(name, acc_no, br_code, (int) pin, Amount, '+', path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        balance = balance + Amount;
        return balance;
    }

    public void newAccount() {
        try {
            newAccount("savingaccount");
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAccount() {
        System.out.println("Enter account info:\nTitle_of_Account");
        try {
            name = reader.next();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Account_Number");
        try {
            acc_no = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Branch_Code");
        try {
            br_code = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        try {
            removeAccount(name, acc_no, br_code, path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void balance() {
        System.out.println("Enter account info:\nTitle_of_Account");
        try {
            name = reader.next();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Account_Number");
        try {
            acc_no = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("Branch_Code");
        try {
            br_code = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        System.out.println("PIN");
        try {
            pin = reader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input");
        }

        try {
            readBalance(name, acc_no, br_code, (int) pin, path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Your account balance is: " + balance);
    }

    public void checkAccount() {
        System.out.println("Enter Title of Account");
        name = reader.next();
        try {
            checkAccount(name, path);
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
