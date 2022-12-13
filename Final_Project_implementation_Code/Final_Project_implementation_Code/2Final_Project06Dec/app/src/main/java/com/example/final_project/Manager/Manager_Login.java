package com.example.final_project.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.final_project.R;

public class Manager_Login extends AppCompatActivity {

    EditText name, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        name= findViewById(R.id.managerNameText);
        password= findViewById(R.id.passwordText);

        login=findViewById(R.id.loginBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nm= "Manager23";
                String pass= "1234";

                if(name.getText().toString().equals(nm) && password.getText().toString().equals(pass)){
                    Intent i= new Intent(getApplicationContext(), Manager_Site.class);
                    startActivity(i);
                }
            }
        });
    }
}