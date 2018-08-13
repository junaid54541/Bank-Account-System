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
public class FixedDepositAccount extends HeadOffice {

    private String name;
    private double acc_no;
    private double br_code;
    private double pin;
    private double date2;
    String path = "C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\fixeddepositaccount.txt";

    public void getAmount() {
        System.out.println("Enter account info:\nTitle_of_Account");
        try {
            name = reader.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }

        System.out.println("Account_Number");
        try {
            acc_no = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }

        System.out.println("Branch_Code");
        try {
            br_code = reader.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }

        System.out.println("PIN");
        try {
            pin = reader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
        }

        try {
            readBalance(name, acc_no, br_code, (int) pin, path);
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (balance == -2) {
            System.out.println("You entered incorrect information");
        } else {
            date2 = year + period1;
            String split[] = date1.split(",");
            if (Double.parseDouble(split[2]) > date2) {
                System.out.println("Take your amount: " + amount);
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) > month)) {
                System.out.println("Take your amount: " + amount);
            } else if ((Double.parseDouble(split[2]) == date2) && (Double.parseDouble(split[1]) == month) && (Double.parseDouble(split[0]) >= day)) {
                System.out.println("Take your amount: " + amount);
            } else {
                System.out.println("Your date doesnot exceeded");
            }
        }
    }

    public void newAccount() {
        try {
            newAccount("fixeddepositaccount");
        } catch (FileNotFoundException a) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
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
