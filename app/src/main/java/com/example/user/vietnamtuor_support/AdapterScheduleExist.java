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

public  class AdapterScheduleExist extends RecyclerView.Adapter<AdapterScheduleExist.ViewHolder>{
    ArrayList<DataScheduleExist> dataSchedulesExists;
    Context context;

    public AdapterScheduleExist(ArrayList<DataScheduleExist> dataNotifications, Context context){
        this.dataSchedulesExists = dataSchedulesExists;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_schedule_exist,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataSchedulesExists.get(position).getName());
        holder.txtAddress.setText(dataSchedulesExists.get(position).getAddress());
        holder.imgService.setImageResource(dataSchedulesExists.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSchedulesExists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtAddress;
        TextView txtName;
        ImageView imgService;
        public ViewHolder(View itemView) {
            super(itemView);
            imgService = (ImageView)itemView.findViewById(R.id.imageServiceExist);
            txtName = (TextView)itemView.findViewById(R.id.textViewServiceName);
            txtAddress = (TextView)itemView.findViewById(R.id.textViewServiceAddress);
        }
    }
}


