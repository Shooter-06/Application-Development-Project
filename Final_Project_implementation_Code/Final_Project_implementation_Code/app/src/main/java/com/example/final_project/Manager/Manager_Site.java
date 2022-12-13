package com.example.final_project.Manager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.final_project.About;
import com.example.final_project.Login_In.MainActivity;
import com.example.final_project.R;
import com.example.final_project.ShowManagerData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Manager_Site extends AppCompatActivity {
    Button about, checkClientAccount;
    FloatingActionButton logout;

//    private ArrayList<String> arrayListTransactions=new ArrayList<>();
//    private ArrayAdapter<String> arrayAdapterTransactions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_site);
        logout= findViewById(R.id.logoutOption);
        checkClientAccount = findViewById(R.id.checkAccountBtn);

//        arrayAdapterTransactions = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, arrayListTransactions);
//
//        ListView listView= (ListView) findViewById(R.id.listViewRecords);
//        listView.setAdapter(arrayAdapterTransactions);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplication(), MainActivity.class);
                startActivity(intent);
            }
        });

        checkClientAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ShowManagerData.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.manager_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() ==R.id.menuAccountsM){

            Toast.makeText(this, "Registered Accounts to the Cole Bank", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplication(), Manager_Site.class);
            startActivity(intent);

        }else if(item.getItemId() ==R.id.menuAboutPageM){

            Toast.makeText(this, "About Page for Cole Bank ", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(getApplication(), About.class);
            intent.putExtra("developer", "Yassine Top G");
            startActivity(intent);
        }
        return true;
    }
}