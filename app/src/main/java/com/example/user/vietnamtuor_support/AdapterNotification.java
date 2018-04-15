package com.example.user.vietnamtuor_support;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
/**
 * Created by User on 15/04/2018.
 */

public class AdapterNotification extends RecyclerView.Adapter<AdapterNotification.ViewHolder>{
    ArrayList<DataNotification> dataNotifications;
    Context context;

    public AdapterNotification(ArrayList<DataNotification> dataNotifications, Context context){
        this.dataNotifications = dataNotifications;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_notification,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataNotifications.get(position).getName());
        holder.imgMain.setImageResource(dataNotifications.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataNotifications.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgMain;
        public ViewHolder(View itemView) {
            super(itemView);
            imgMain = (ImageView)itemView.findViewById(R.id.imageUser);
            txtName = (TextView)itemView.findViewById(R.id.textViewEventContent);
        }
    }
}
