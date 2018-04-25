package com.example.user.vietnamtuor_support;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 14/04/2018.
 */

public class AdapterMain extends RecyclerView.Adapter<AdapterMain.ViewHolder> {
    ArrayList<DataMain> dataMains;
    Context context;

    public AdapterMain(ArrayList<DataMain> dataMains, Context context) {
        this.dataMains = dataMains;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.custom_main, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DataMain dataMain = dataMains.get(position);
        holder.txtName.setText(dataMain.getName());
        holder.imgMain.setImageBitmap(dataMain.getImage());
        holder.cardView.setTag(dataMain.getId());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iServiceInfo = new Intent(context, Activity_serviceinfo.class);
                iServiceInfo.putExtra("id", (int) view.getTag());
                iServiceInfo.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(iServiceInfo);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataMains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgMain;
        CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtMainName);
            imgMain = itemView.findViewById(R.id.imgMainPhoto);
            cardView = itemView.findViewById(R.id.cardViewMain);
        }
    }
}
