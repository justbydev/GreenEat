package com.zerowaste.greeneat;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Shop_list_Activity extends AppCompatActivity {
    EditText shop_search;
    RecyclerView shop_list_recyclerview;
    ArrayList<Shop_Info> shoplist=null;
    private Shop_list_Adapter shop_list_adapter;
    static Context shop_list_activity_context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_list);

        setting();
        getting_shop_data();
        setting_recyclerview();
    }

    public void setting(){
        shop_list_activity_context=this;
        shop_search=findViewById(R.id.shop_search);
        shop_list_recyclerview=findViewById(R.id.shop_list);
    }

    public void getting_shop_data(){
//        for(int i=0; i<가게 수; i++){
//            나중에는 서버로부터 얻어올 함수
//        }
        shoplist=new ArrayList<>();
        ArrayList<String> menu=new ArrayList<>();
        menu.add("블루베리 베이글");
        menu.add("모닝 베이글");
        menu.add("콥 샐러드");
        Shop_Info info=new Shop_Info("그린잇",
                "서울특별시 마포구 백범로1길",
                "베이글/샐러드 전문점",
                menu);
        shoplist.add(info);

    }
    public void setting_recyclerview(){
        shop_list_recyclerview.setHasFixedSize(true);
        shop_list_recyclerview.setLayoutManager(new LinearLayoutManager(shop_list_activity_context));
        shop_list_adapter=new Shop_list_Adapter(shoplist);
        shop_list_recyclerview.setAdapter(shop_list_adapter);
    }
}
