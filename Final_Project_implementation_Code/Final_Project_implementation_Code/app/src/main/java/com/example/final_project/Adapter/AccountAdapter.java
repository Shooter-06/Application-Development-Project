package com.example.final_project.Adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.final_project.Database.DatabaseHelper;
import com.example.final_project.Database.DatabaseHelperRegister;
import com.example.final_project.R;
import com.example.final_project.ToDo.Logins;

import java.util.List;

public class AccountAdapter  extends BaseAdapter {

    private Context context;
    private List<Logins> list;
    Button del;
    DatabaseHelperRegister db;
    Button deleteAcc;


    public AccountAdapter(Context context, List<Logins> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= View.inflate(context, R.layout.list_row, null);

        TextView firstName= view.findViewById(R.id.firstNameTxt);
        TextView lastName= view.findViewById(R.id.lastNameTxt);
        deleteAcc= view.findViewById(R.id.deleteAccount);

        firstName.setText(list.get(position).getFirstName());
        lastName.setText(list.get(position).getLastName());


        deleteAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=new DatabaseHelperRegister(view.getContext());
                db .deleteProduct(list.get(position).getFirstName());
                Toast.makeText(view.getContext(), "Account owner closed permanently !!", Toast.LENGTH_SHORT);
            }
        });
        return view;
    }
}
