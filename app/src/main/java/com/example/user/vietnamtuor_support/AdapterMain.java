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
 * Created by User on 14/04/2018.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    ArrayList<DataMain> dataMains;
    Context context;

    public AdapterMain(ArrayList<DataMain> dataMains, Context context){
        this.dataMains = dataMains;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_main,parent,false)
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtName.setText(dataMains.get(position).getName());
        holder.imgMain.setImageResource(dataMains.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return dataMains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        ImageView imgMain;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtMainName);
            imgMain = (ImageView)itemView.findViewById(R.id.imgMainPhoto);

        }
    }
}
