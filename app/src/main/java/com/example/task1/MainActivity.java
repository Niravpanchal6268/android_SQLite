package com.example.task1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email, mobile;
    Button add_btn, view_btn, alldata_btn, update_btn,delete_btn;


    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add_btn = findViewById(R.id.add_btn_id);
        name = findViewById(R.id.name_id);
        email = findViewById(R.id.email_id);
        mobile = findViewById(R.id.mobile_id);
        update_btn = findViewById(R.id.update_btn_id);
        view_btn = findViewById(R.id.viwe_btn_id);
        alldata_btn = findViewById(R.id.alldata_btn_id);
        delete_btn=findViewById(R.id.delete_btn_id);
        myDBHelper = new MyDBHelper(this);


        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Mobile = mobile.getText().toString();

                if (Name.isEmpty() || Email.isEmpty() || Mobile.isEmpty()) {
                    Toast.makeText(MainActivity.this, "fill all", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "fill", Toast.LENGTH_SHORT).show();
                    boolean insert = myDBHelper.insertcontact(Name, Email, Mobile);
                    if (insert == true) {
                        Toast.makeText(MainActivity.this, "contact save", Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "Name" + Name, Toast.LENGTH_SHORT).show();
                        name.setText(" ");
                        email.setText(" ");
                        mobile.setText(" ");

                    } else {
                        Toast.makeText(MainActivity.this, "contact not save", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });
        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor se = myDBHelper.showdata();
                if (se.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No enty fond", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                while (se.moveToNext()) {
                    stringBuffer.append("Name:" + se.getString(0) + "\n");
                    stringBuffer.append("Email:" + se.getString(1) + "\n");
                    stringBuffer.append("mobile:" + se.getString(2) + "\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("user Enteries");
                builder.setMessage(stringBuffer.toString());
                builder.show();

            }
        });

        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                String Email = email.getText().toString();
                String Mobile = mobile.getText().toString();
                boolean checkupdatedata = myDBHelper.updatecontact(Name, Email, Mobile);
                if (checkupdatedata == true) {
                    Toast.makeText(MainActivity.this, "Entry update", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Entry not Update", Toast.LENGTH_SHORT).show();
                }


            }
        });

        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name = name.getText().toString();
                boolean delete= myDBHelper.deletcontact(Name);
                if (delete==true)
                {
                    Toast.makeText(MainActivity.this, "Delete successful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Delete fail ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        alldata_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListActivity.class));
            }
        });


    }


}