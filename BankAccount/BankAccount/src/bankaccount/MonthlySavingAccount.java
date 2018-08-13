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
public class MonthlySavingAccount extends HeadOffice {

    private String name;
    private double acc_no;
    private double br_code;
    private double pin;
    private double profit;
    String path = "C:\\Users\\Hp\\Documents\\NetBeansProjects\\BankAccount\\BankAccount\\src\\bankaccount\\monthlysavingaccount.txt";

    public void profit() {
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

        if (balance == -2) {
            System.out.println("You entered incorrect information");
        } else {
            String split[] = date1.split(",");
            if (Double.parseDouble(split[0]) >= day && Double.parseDouble(split[2]) > year) {
                profit = (balance / 100000) * 400;
                System.out.println("Take your amount: " + profit);
                try {
                    updateDate(name, acc_no, br_code, pin, path);
                } catch (FileNotFoundException a) {
                    System.out.println("File Not Found");
                } catch (IOException ex) {
                    Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (Double.parseDouble(split[0]) >= day && Double.parseDouble(split[2]) == year && Double.parseDouble(split[1]) > month) {
                profit = (balance / 100000) * 400;
                System.out.println("Take your amount: " + profit);
                try {
                    updateDate(name, acc_no, br_code, pin, path);
                } catch (FileNotFoundException a) {
                    System.out.println("File Not Found");
                } catch (IOException ex) {
                    Logger.getLogger(SavingAccount.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("Your date doesnot exceed a month");
            }
        }
    }

    public void newAccount() {
        try {
            newAccount("monthlysavingaccount");
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
