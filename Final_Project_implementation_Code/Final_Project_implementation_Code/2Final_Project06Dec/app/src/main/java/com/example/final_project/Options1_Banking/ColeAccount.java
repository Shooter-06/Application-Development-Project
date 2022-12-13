package com.example.final_project.Options1_Banking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.Options1_Banking.CheckingAccount;
import com.example.final_project.Options1_Banking.SavingsAccount;
import com.example.final_project.R;
import com.example.final_project.ToDo.Account;
import com.example.final_project.ToDo.BK;

public class ColeAccount extends AppCompatActivity {

    private BK bk;

    private EditText accountNum, amountT, balance;
    private Button radCheck, radSav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cole_account);

        this.bk= new BK();

        accountNum= findViewById(R.id.textAcccountN);
        amountT=findViewById(R.id.textAmount);
        balance= findViewById(R.id.txtBalance);
        radCheck=findViewById(R.id.radButtonCkeck);
        radSav=findViewById(R.id.radButtonSave);
    }

    public void withdraw(View view){
        try {
            int accNum= Integer.parseInt(accountNum.getText().toString());
            double amount= Double.parseDouble(amountT.getText().toString());

            if(bk.withdraw(accNum, amount)){
                Toast.makeText(this, "Transaction was made successful !", Toast.LENGTH_SHORT).show();
                this.balance.setText(String.format("$%.2f", bk.getAccount(accNum).getBalance()));
                amountT.setText("");
            }else{
                Toast.makeText(this, "Transaction failed", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception E){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }

    public void Deposit(View view){
        try {
            int accNum= Integer.parseInt(accountNum.getText().toString());
            double amount= Double.parseDouble(amountT.getText().toString());

            if(bk.deposit(accNum, amount)){
                Toast.makeText(this, "Transaction was made successful !", Toast.LENGTH_SHORT).show();
                this.balance.setText(String.format("$%.2f", bk.getAccount(accNum).getBalance()));
                amountT.setText("");
            }else{
                Toast.makeText(this, "Transaction failed", Toast.LENGTH_SHORT).show();
            }
        }catch (Exception E){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkBalance(View view){
        try {
            int accNum= Integer.parseInt(accountNum.getText().toString());
            this.balance.setText(String.format("$%.2f", bk.getAccount(accNum).getBalance()));
            amountT.setText("");
        }catch (Exception E){
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        }
    }

    public void createAccount(View view){
        Account account= null;

        if(this.radCheck.isActivated()){
            account =new CheckingAccount(BK.getNextAccount(), 2);
        }else {
            account =new SavingsAccount(BK.getNextAccount(), 1.75);
        }

        bk.addAccount(account);

        Toast.makeText(this, "Account has been created - Account Number:  " +account.getAccountId()
                , Toast.LENGTH_SHORT).show();

        amountT.setText("");
        accountNum.setText("");
        balance.setText("");
    }
}