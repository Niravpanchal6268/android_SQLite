package com.example.task1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listView;
    MyDBHelper myDBHelper;
    ArrayList arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = findViewById(R.id.list_view_id);
        myDBHelper = new MyDBHelper(this);

        viewdata();


    }

    public void back(View view) {
        startActivity(new Intent(ListActivity.this, MainActivity.class));
    }

    private void viewdata() {
        Cursor cursor = myDBHelper.showdata();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "no datashow", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                arrayList.add(cursor.getString(0));
                arrayList.add(cursor.getString(1));
                arrayList.add(cursor.getString(2));


            }
            ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);
            listView.setAdapter(adapter);

        }
    }
}