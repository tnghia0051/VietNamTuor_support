package com.example.user.vietnamtuor_support.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.vietnamtuor_support.View.Schedule.Activity_schedule_main;
import com.example.user.vietnamtuor_support.Model.ObjectClass.DataSchedule;
import com.example.user.vietnamtuor_support.R;

import java.util.ArrayList;

/**
 * Created by User on 22/04/2018.
 */

public  class AdapterSchedule extends RecyclerView.Adapter<AdapterSchedule.ViewHolder>{
    ArrayList<DataSchedule> dataSchedules;
    Context context;

    public AdapterSchedule(ArrayList<DataSchedule> dataSchedules, Context context){
        this.dataSchedules = dataSchedules;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_schedule_list,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataSchedules.get(position).getName());
        holder.txtUser.setText(dataSchedules.get(position).getUser());
        holder.txtDate.setText(dataSchedules.get(position).getDate());
        holder.imgMain.setImageBitmap(dataSchedules.get(position).getImage());
        holder.cardView.setTag(dataSchedules.get(position).getId());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iServiceInfo = new Intent(context, Activity_schedule_main.class);
                iServiceInfo.putExtra("id", (int) view.getTag());
                iServiceInfo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(iServiceInfo);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSchedules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        TextView txtDate;
        TextView txtUser;
        ImageView imgMain;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            imgMain = itemView.findViewById(R.id.imageScheduleType);
            txtName = itemView.findViewById(R.id.textViewScheduleContent);
            txtUser = itemView.findViewById(R.id.textViewUserRequest);
            txtDate = itemView.findViewById(R.id.textViewScheduleDate);
            cardView = itemView.findViewById(R.id.cardViewSuKien);
        }
    }
}


