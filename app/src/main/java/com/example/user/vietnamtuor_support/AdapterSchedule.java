package com.example.user.vietnamtuor_support;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        holder.imgMain.setImageResource(dataSchedules.get(position).getImage());
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
        public ViewHolder(View itemView) {
            super(itemView);
            imgMain = (ImageView)itemView.findViewById(R.id.imageScheduleType);
            txtName = (TextView)itemView.findViewById(R.id.textViewScheduleContent);
            txtUser = (TextView)itemView.findViewById(R.id.textViewUserRequest);
            txtDate = (TextView)itemView.findViewById(R.id.textViewScheduleDate);
        }
    }
}


