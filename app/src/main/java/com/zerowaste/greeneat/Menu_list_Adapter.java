package com.zerowaste.greeneat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Menu_list_Adapter extends RecyclerView.Adapter {
    ArrayList<Menu> menu=null;
    static Context context;
    public Menu_list_Adapter(ArrayList<Menu> menu){
        this.menu=menu;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout menu_layout;
        ImageView image;
        TextView menu_name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            menu_layout=itemView.findViewById(R.id.menu_layout);
            image=itemView.findViewById(R.id.menu_image);
            menu_name=itemView.findViewById(R.id.menu_name);
            context=itemView.getContext();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.menu_item, parent, false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.image.setImageResource(menu.get(position).getImage());
        myViewHolder.menu_name.setText(menu.get(position).getMenu_name());

    }

    @Override
    public int getItemCount() {
        return menu==null?0:menu.size();
    }
}
