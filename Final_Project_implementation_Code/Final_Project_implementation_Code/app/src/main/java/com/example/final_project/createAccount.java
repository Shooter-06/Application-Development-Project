package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class createAccount extends AppCompatActivity {
    EditText name, amount;
    Button save;
    FloatingActionButton information,backFB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        name= findViewById(R.id.nameTxt);
        amount= findViewById(R.id.balanceTxt);
        save= findViewById(R.id.saveButtonNewAcc);
        backFB=findViewById(R.id.BackPage);

        information= findViewById(R.id.info);

        save.setOnClickListener(new View.OnClickListener() {
            String username = getIntent().getStringExtra("USER");
            String initialAmount = getIntent().getStringExtra("AMOUNT");

            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomePage.class);
                username= name.getText().toString();
                intent.putExtra("USER", username);
                startActivity(intent);
            }
        });

        information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snack = Snackbar.make(v, "The account balance is initial set to 0",
                        Snackbar.LENGTH_INDEFINITE);
                snack.setAction("close", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snack.dismiss();
                    }
                }).setActionTextColor(getResources().getColor(android.R.color.holo_red_dark)).show();

            }
        });

        backFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), BeforeCreatingAccount.class);
                startActivity(intent);
            }
        });
    }
}