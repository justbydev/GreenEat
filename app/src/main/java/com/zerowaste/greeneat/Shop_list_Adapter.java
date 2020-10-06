package com.zerowaste.greeneat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Shop_list_Adapter extends RecyclerView.Adapter {
    ArrayList<Shop_Info> shop_list=null;
    static Context context;
    public Shop_list_Adapter(ArrayList<Shop_Info> shop_list){
        this.shop_list=shop_list;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView shop_name, shop_address, shop_category;
        CardView shop_cardview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_name=itemView.findViewById(R.id.shop_name);
            shop_address=itemView.findViewById(R.id.shop_address);
            shop_category=itemView.findViewById(R.id.shop_category);
            shop_cardview=itemView.findViewById(R.id.shop_cardview);
            context=itemView.getContext();
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.shop_item, parent, false);
        MyViewHolder vh=new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final String shop_name=shop_list.get(position).getShop_name();
        final String shop_address=shop_list.get(position).getShop_address();
        final String shop_category=shop_list.get(position).getShop_category();
        final ArrayList<String> shop_menu=shop_list.get(position).getMenu_name();
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.shop_name.setText(shop_name);
        myViewHolder.shop_address.setText(shop_address);
        myViewHolder.shop_category.setText(shop_category);
        myViewHolder.shop_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Each_shop_Activity.class);
                intent.putExtra("shop_name", shop_name);
                intent.putExtra("shop_address", shop_address);
                intent.putExtra("shop_category", shop_category);
                intent.putExtra("shop_menu", shop_menu);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shop_list==null?0:shop_list.size();
    }
}
