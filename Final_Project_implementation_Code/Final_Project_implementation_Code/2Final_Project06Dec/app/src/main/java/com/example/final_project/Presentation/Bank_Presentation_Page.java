package com.example.final_project.Presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.final_project.Login_In.MainActivity;
import com.example.final_project.bank_option1_presentation;
import com.example.final_project.R;
import com.example.final_project.bank_option2_presentation;

public class Bank_Presentation_Page extends AppCompatActivity {

    Button option1, option2, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_presentation_page);

        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        logout=findViewById(R.id.logoutBtn);



        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), bank_option1_presentation.class);
                startActivity(i);
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), bank_option2_presentation.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}