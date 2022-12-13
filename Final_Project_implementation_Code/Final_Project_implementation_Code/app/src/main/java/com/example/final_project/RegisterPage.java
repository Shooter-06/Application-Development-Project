package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.Database.DatabaseHelperRegister;
import com.example.final_project.Login_In.MainActivity;

public class RegisterPage extends AppCompatActivity {
EditText FName,LName,PWord,PWordConfirm;

Button save;
DatabaseHelperRegister myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        FName=findViewById(R.id.editTextFName);
        LName=findViewById(R.id.editTextLName);
        PWord=findViewById(R.id.editTextPWord);
        PWordConfirm=findViewById(R.id.editTextPWordConfirm);

        myDB=new DatabaseHelperRegister(this);

        save=findViewById(R.id.button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first=FName.getText().toString();
                String last=LName.getText().toString();
                String pw=PWordConfirm.getText().toString();
                String cpw=PWordConfirm.getText().toString();
                myDB.insert(first,last,pw,cpw);
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                Toast.makeText(getApplicationContext(), "New Account Has been Created", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}
