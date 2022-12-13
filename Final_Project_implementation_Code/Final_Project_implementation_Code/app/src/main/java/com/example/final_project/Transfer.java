package com.example.final_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Transfer extends AppCompatActivity {
EditText balance, amount, sender,receiver;
Button transfer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        balance=findViewById(R.id.textView18);
        receiver=findViewById(R.id.textView19);
        sender=findViewById(R.id.textView20);
        amount=findViewById(R.id.textView21);
        transfer=findViewById(R.id.button3);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel= new NotificationChannel("My notification","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bal=Double.parseDouble(balance.getText().toString());
                double amnt=Double.parseDouble(amount.getText().toString());
                if(!balance.getText().equals("") || !amount.getText().equals("") || !sender.getText().equals("") || !receiver.getText().equals("")) {
                    if (bal < amnt) {
                        Toast.makeText(Transfer.this, "You don't have enough funds to perform this transfer", Toast.LENGTH_SHORT).show();
                    } else {
                        double trans = bal - amnt;
                        NotificationCompat.Builder builder = new NotificationCompat.Builder(Transfer.this, "My notification");
                        builder.setContentTitle("Transfer");
                        builder.setContentText("Your transfer to "+receiver.getText().toString()+" is successful.");
                        builder.setSmallIcon(R.drawable.ic_baseline_attach_money_24);
                        builder.setAutoCancel(true);
                        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(Transfer.this);
                        managerCompat.notify(1, builder.build());
                    }
                }else{
                    Toast.makeText(Transfer.this, "Every field must be filled.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}