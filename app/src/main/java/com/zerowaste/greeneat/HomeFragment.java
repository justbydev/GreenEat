package com.zerowaste.greeneat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    ImageView shop_list;
    Context context;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.home, container, false);

        setting(v);
        setlistener();

        return v;
    }

    public void setting(View v){
        context=getContext();
        shop_list=v.findViewById(R.id.shop_list);
    }

    public void setlistener(){
        shop_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Shop_list_Activity.class);
                startActivity(intent);
            }
        });
    }

}
