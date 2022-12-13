package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.final_project.Adapter.AccountAdapter;
import com.example.final_project.Database.DatabaseHelper;
import com.example.final_project.Database.DatabaseHelperRegister;

import java.util.List;

public class ShowManagerData extends AppCompatActivity {

    ListView lv;
    DatabaseHelperRegister loginDb;
    DatabaseHelperRegister accountDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_manager_data);

        lv= findViewById(R.id.listview);

        loginDb= new DatabaseHelperRegister(getApplicationContext());

        AccountAdapter accountAdapter= new AccountAdapter(this, accountDb.getUserLogins());
        lv.setAdapter(accountAdapter);
    }
}