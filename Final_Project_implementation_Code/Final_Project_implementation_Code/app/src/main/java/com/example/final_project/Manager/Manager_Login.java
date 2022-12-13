package com.example.final_project.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.final_project.Login_In.MainActivity;
import com.example.final_project.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Manager_Login extends AppCompatActivity {

    EditText name, password;
    Button login;
    FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        name= findViewById(R.id.managerNameText);
        password= findViewById(R.id.passwordText);
        back= findViewById(R.id.floatingActionButton);

        login=findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm= "Manager23";
                String pass= "1234";

                if(name.getText().toString().equals(nm) && password.getText().toString().equals(pass)){
                    Intent intent= new Intent(getApplicationContext(), Manager_Site.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), "Please enter the correct Username/Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}