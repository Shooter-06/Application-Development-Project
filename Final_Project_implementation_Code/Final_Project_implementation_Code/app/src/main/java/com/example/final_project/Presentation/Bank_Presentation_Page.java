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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Bank_Presentation_Page extends AppCompatActivity {

    FloatingActionButton floatOption1, floatOption2, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_presentation_page);

        logout=findViewById(R.id.floatLogout);
        floatOption1= findViewById(R.id.goOption);
        floatOption2= findViewById(R.id.goOption2);



        floatOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), bank_option1_presentation.class);
                startActivity(i);
            }
        });

        floatOption2.setOnClickListener(new View.OnClickListener() {
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