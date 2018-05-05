package com.example.user.vietnamtuor_support.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.vietnamtuor_support.Model.ObjectClass.DataSchedule;
import com.example.user.vietnamtuor_support.R;

import java.util.ArrayList;

/**
 * Created by User on 22/04/2018.
 */

public  class AdapterScheduleExist extends RecyclerView.Adapter<AdapterScheduleExist.ViewHolder>{
    ArrayList<DataSchedule> dataSchedules;
    Context context;

    public AdapterScheduleExist(ArrayList<DataSchedule> dataNotifications, Context context){
        this.dataSchedules = dataSchedules;
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
        holder.txtName.setText(dataSchedules.get(position).getName());
        holder.txtAddress.setText(dataSchedules.get(position).getAddress());
        holder.imgService.setImageBitmap(dataSchedules.get(position).getImage());
        holder.txtDateCreated.setText(dataSchedules.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dataSchedules.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtAddress;
        TextView txtName, txtDateCreated;
        ImageView imgService;
        public ViewHolder(View itemView) {
            super(itemView);
            imgService = (ImageView)itemView.findViewById(R.id.imageServiceExist);
            txtName = (TextView)itemView.findViewById(R.id.textViewServiceName);
            txtAddress = (TextView)itemView.findViewById(R.id.textViewServiceAddress);
            txtDateCreated = itemView.findViewById(R.id.textViewExistDateDate);
        }
    }
}


