package com.example.final_project.ToDo;

import java.util.ArrayList;

public class BK {

    private static int accountCounter= 0;
    private static double chargerFee=2.5;
    private static double IR= 0.05;

    private ArrayList<Account> accounts;

    public BK(){accounts= new ArrayList<>();}

    public void addAccount(Account account){this.accounts.add(account);}

    public Account getAccount(int accountID){
        for(Account account:accounts){
            if(account.getAccountId()== accountID){
                return  account;
            }
        }
        return null;
    }

    public boolean deposit(int accountID, double amount){
        Account account= this.getAccount(accountID);

        if(account == null){
            return false;
        }

        if(amount > 0){
            account.deposit(amount);
            return  true;
        }

        return false;
    }

    public boolean withdraw(int accountID, double amount){
        Account account = this.getAccount(accountID);

        if (amount <=0 || account.getBalance() < amount){
            return false;
        }

        account.withdraw(amount);

        return true;
    }

    public static int getNextAccount(){
        accountCounter++;
        return accountCounter;
    }

    public static double getFee() {
        return chargerFee;
    }

    public static double getIR() {
        return IR;
    }

}
