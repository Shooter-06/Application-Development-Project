package com.example.final_project.Login_In;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.Database.DatabaseHelperRegister;
import com.example.final_project.HomePage;
import com.example.final_project.Manager.Manager_Login;
import com.example.final_project.Presentation.Bank_Presentation_Page;
import com.example.final_project.R;
import com.example.final_project.RegisterPage;
import com.example.final_project.ToDo.Logins;

public class MainActivity extends AppCompatActivity {
    EditText firstName, lastName,passW;

    TextView noAccount;

    Button login;
    Button manager ;
    DatabaseHelperRegister myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Bank Transactions");

        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.TextFName);
        lastName = findViewById(R.id.TextFName);
        passW = findViewById(R.id.TextPWord);

        noAccount = findViewById(R.id.textViewRegister);

        manager=findViewById(R.id.managerOption);

        myDB= new DatabaseHelperRegister(this);

        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), Manager_Login.class);
                startActivity(i);
            }
        });

        noAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegisterPage.class);
                startActivity(i);
            }
        });
        login = findViewById(R.id.button2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn=firstName.getText().toString();
                String ln=lastName.getText().toString();
                String pw=passW.getText().toString();

                DatabaseHelperRegister mydb = new DatabaseHelperRegister(getApplicationContext());

                if (!mydb.getUserLogins().isEmpty()) {
                    for (Logins login : mydb.getUserLogins()) {
                        if (login.getFirstName().equals(fn) && login.getPassword().equals(pw) && login.getLastName().equals(ln)) {
                            Intent intent = new Intent(getApplicationContext(), Bank_Presentation_Page.class);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "The User is Logged In !!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Can't login in this page", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}