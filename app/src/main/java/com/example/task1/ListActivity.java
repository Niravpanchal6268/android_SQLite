package com.example.task1;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    MyDBHelper myDBHelper;
    RecyclerView recyclerView;
    ArrayList<model> alist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        recyclerView = findViewById(R.id.recycle_view_id);
        myDBHelper = new MyDBHelper(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new MyDBHelper(this).showdata();
        alist = new ArrayList<>();
        while (cursor.moveToNext()) {
            model obj = new model(cursor.getString(1),
                    cursor.getString(3),
                    cursor.getString(2));
            alist.add(obj);
        }
        MyAdapter myAdapter = new MyAdapter(alist);
        recyclerView.setAdapter(myAdapter);

    }

    public void back(View view) {
        startActivity(new Intent(ListActivity.this, MainActivity.class));
    }

//    private void viewdata() {
//        Cursor cursor = myDBHelper.showdata();
//        if (cursor.getCount() == 0) {
//            Toast.makeText(this, "no datashow", Toast.LENGTH_SHORT).show();
//        } else {
//            while (cursor.moveToNext()) {
//                arrayList.add(cursor.getString(0));
//                arrayList.add(cursor.getString(1));
//                arrayList.add(cursor.getString(2));
//
//
//            }


}