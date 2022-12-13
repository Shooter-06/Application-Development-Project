package com.example.final_project.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.final_project.R;

public class ClientAccounts extends AppCompatActivity {

    Button allAccounts;
    ListView lv = (ListView) findViewById(R.id.listview);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_accounts);

        allAccounts = findViewById(R.id.button4);

        allAccounts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}