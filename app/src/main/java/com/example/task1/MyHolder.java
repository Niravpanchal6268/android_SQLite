package com.example.task1;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder {

    TextView name_v,mobile_v,email_v;

    public MyHolder(@NonNull View itemView) {
        super(itemView);
       name_v=itemView.findViewById(R.id.name_c_id);
       mobile_v=itemView.findViewById(R.id.mobile_c_id);
       email_v=itemView.findViewById(R.id.email_c_id);


    }
}
