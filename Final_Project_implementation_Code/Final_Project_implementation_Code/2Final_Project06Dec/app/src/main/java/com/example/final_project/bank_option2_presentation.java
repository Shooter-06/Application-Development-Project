package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.final_project.Options1_Banking.ColeAccount;
import com.example.final_project.Presentation.Bank_Presentation_Page;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class bank_option2_presentation extends AppCompatActivity {
    FloatingActionButton back, forward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_option2_presentation);


        back= findViewById(R.id.floatingActionButtonBack);
        forward= findViewById(R.id.floatingActionButtonForward);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), Bank_Presentation_Page.class);
                startActivity(intent);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), HomePage.class);
                startActivity(intent);
            }
        });
    }
}