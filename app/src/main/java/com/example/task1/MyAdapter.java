package com.example.task1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    ArrayList<model> arrayList;

    public MyAdapter(ArrayList<model> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.listcard,parent,false);



        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.email_v.setText(arrayList.get(position).getEmail());
        holder.name_v.setText(arrayList.get(position).getName());
        holder.mobile_v.setText(arrayList.get(position).getMobile());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
