package com.example.final_project;

import static com.example.final_project.R.id.FButtonForward;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.final_project.Login_In.MainActivity;
import com.example.final_project.Presentation.Bank_Presentation_Page;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BeforeCreatingAccount extends AppCompatActivity {

    FloatingActionButton  forward,back,logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_creating_account);

        forward= findViewById(R.id.FButtonForward);
        back= findViewById(R.id.ButtonBackPage);
        logOut= findViewById(R.id.logout);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), createAccount.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), bank_option2_presentation.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}