package com.zerowaste.greeneat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Each_shop_Activity extends AppCompatActivity {
    TextView shop_name, shop_address, shop_category;
    RecyclerView menu_list_recyclerview;
    Intent intent;
    String shopname, shopaddress, shopcategory;
    ArrayList<String> menu_name;
    ArrayList<Menu> menu=null;
    static Context each_shop_activity_context;
    Menu_list_Adapter menu_list_adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.each_shop);

        setting();
        getting_menu_data();
        setting_recyclerview();
    }

    public void setting(){
        each_shop_activity_context=this;
        shop_name=findViewById(R.id.shop_name);
        shop_address=findViewById(R.id.shop_address);
        shop_category=findViewById(R.id.shop_category);
        menu_list_recyclerview=findViewById(R.id.menu_list);

        intent=getIntent();
        shopname=intent.getStringExtra("shop_name");
        shopaddress=intent.getStringExtra("shop_address");
        shopcategory=intent.getStringExtra("shop_category");
        menu_name=new ArrayList<>();
        menu_name=intent.getStringArrayListExtra("shop_menu");

        shop_name.setText(shopname);
        shop_address.setText(shopaddress);
        shop_category.setText(shopcategory);
    }

    public void getting_menu_data(){
        //나중에는 서버에서 실제 메뉴를 얻어올 함수
        menu=new ArrayList<>();
        for(int i=0; i<menu_name.size(); i++){
            Menu each=new Menu(R.drawable.logo, menu_name.get(i));
            menu.add(each);
        }
    }

    public void setting_recyclerview(){
        menu_list_recyclerview.setHasFixedSize(true);
        menu_list_recyclerview.setLayoutManager(new GridLayoutManager(each_shop_activity_context, 3));
        menu_list_adapter=new Menu_list_Adapter(menu);
        menu_list_recyclerview.setAdapter(menu_list_adapter);
    }
}
