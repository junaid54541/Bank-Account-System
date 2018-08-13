/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class Customer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double balance;
        int check = 0;
        String passward;
        Scanner reader = new Scanner(System.in);
        SavingAccount save = new SavingAccount();
        MonthlySavingAccount monthlysave = new MonthlySavingAccount();
        CurrentAccount current = new CurrentAccount();
        FixedDepositAccount fda = new FixedDepositAccount();
        HeadOffice head = new HeadOffice();

        System.out.println("WELCOME TO ONLINE BANKING SYSTEM\nSign in as?\n1.Admin\n2.User\n3.Exit");
        try {
            int g = reader.nextInt();
            switch (g) {
                case 1:
                    System.out.println("Enter passward");
                    passward = reader.next();
                    try {
                        check = head.checkpassward(passward);
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found");
                    } catch (IOException ex) {
                        Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (check == 1) {
                        System.out.println("1.Requests\n2.Remove Account\n3.Change Passward\n4.Exit");
                        int z = reader.nextInt();
                        switch (z) {
                            case 1:
                                try {
                                    head.checkRequests();
                                } catch (FileNotFoundException a) {
                                    System.out.println("File Not Found");
                                } catch (IOException ex) {
                                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 2:
                                System.out.println("1.PLS Saving Account\n2.Current Account\n3.Monthly Saving Account");
                                int c = reader.nextInt();
                                switch (c) {
                                    case 1:
                                        save.removeAccount();
                                        break;
                                    case 2:
                                        current.removeAccount();
                                        break;
                                    case 3:
                                        monthlysave.removeAccount();
                                        break;
                                }
                                break;
                            case 3:
                                try {
                                    head.changePassward();
                                } catch (IOException ex) {
                                    Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 4:
                                break;
                        }
                    } else {
                        System.out.println("You entered incorrect passward");
                    }
                    break;
                case 2:
                    System.out.println("1.CASH WITHDRAWL\n2.CASH DEPOSIT\n3.MONTHLY PROFIT\n4.NEW ACCOUNT\n5.OTHERS\n6.Exit");
                    try {
                        int i = reader.nextInt();
                        switch (i) {
                            case 1:
                                System.out.println("1.PLS Saving Account\n2.Current Account");
                                try {
                                    int c = reader.nextInt();

                                    switch (c) {
                                        case 1:
                                            balance = save.debitAmount();
                                            if (balance == -1) {
                                                System.out.println("Your account balance is insufficient");
                                            } else if (balance == -2) {
                                                System.out.println("You entered incorrect information");
                                            } else {
                                                System.out.println("Remaining Balance " + balance);
                                            }
                                            break;
                                        case 2:
                                            balance = current.debitAmount();
                                            if (balance == -1) {
                                                System.out.println("Your account balance is insufficient");
                                            } else if (balance == -2) {
                                                System.out.println("You entered incorrect information");
                                            } else {
                                                System.out.println("Remaining Balance " + balance);
                                            }
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input");
                                }
                                break;
                            case 2:
                                System.out.println("1.PLS Saving Account\n2.Current Account");
                                try {
                                    int d = reader.nextInt();
                                    switch (d) {
                                        case 1:
                                            balance = save.creditAmount();
                                            if (balance == -2) {
                                                System.out.println("You entered incorrect information");
                                            } else {
                                                System.out.println("Remaining Balance " + balance);
                                            }
                                            break;
                                        case 2:
                                            balance = current.creditAmount();
                                            if (balance == -2) {
                                                System.out.println("You entered incorrect information");
                                            } else {
                                                System.out.println("Remaining Balance " + balance);
                                            }
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            case 3:
                                monthlysave.profit();
                                break;
                            case 4:
                                System.out.println("1.PLS Saving Account\n2.Current Account\n3.Monthly Saving Account\n4.Fixed Deposit Account");
                                try {
                                    int b = reader.nextInt();
                                    switch (b) {
                                        case 1:
                                            save.newAccount();
                                            break;
                                        case 2:
                                            current.newAccount();
                                            break;
                                        case 3:
                                            monthlysave.newAccount();
                                            break;
                                        case 4:
                                            fda.newAccount();
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid Input");
                                }
                                break;
                            case 5:
                                System.out.println("1.Account Balance\n2.Profit Information\n3.Fixed Deposit\n4.Check New Account");
                                try {
                                    int e = reader.nextInt();
                                    switch (e) {
                                        case 1:
                                            System.out.println("1.PLS Saving Account\n2.Current Account");
                                            try {
                                                int f = reader.nextInt();
                                                switch (f) {
                                                    case 1:
                                                        save.balance();
                                                        break;
                                                    case 2:
                                                        current.balance();
                                                        break;
                                                }
                                            } catch (InputMismatchException a) {
                                                System.out.println("Invalid Input");
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Interest rate of monthly saving account is 0.4%\nInterest rate of fixed deposit account is:\n5% for 1 year\n5.22% for 3 years\n5.39% for 5 years\n6.35% for 10 years");
                                            break;
                                        case 3:
                                            fda.getAmount();
                                            break;
                                        case 4:
                                            System.out.println("1.PLS Saving Account\n2.Current Account\n3.Monthly Saving Account\n4.Fixed Deposit Account");
                                            int s=reader.nextInt();
                                            switch(s){
                                                case 1:
                                                    save.checkAccount();
                                                    break;
                                                case 2:
                                                    current.checkAccount();
                                                    break;
                                                case 3:
                                                    monthlysave.checkAccount();
                                                    break;
                                                case 4:
                                                    fda.checkAccount();
                                                    break;
                                            }
                                            break;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid Input");
                                }
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("invalid input");
                    }
                    break;
            }
        } catch (InputMismatchException ex) {
            System.out.println("Invalid Input");
        }
    }
}
