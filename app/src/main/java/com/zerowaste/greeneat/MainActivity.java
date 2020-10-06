package com.zerowaste.greeneat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ImageView alarm;
    FrameLayout container;
    BottomNavigationView bottom;
    HomeFragment home=null;
    LikeFragment like=null;
    MypageFragment mypage=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting();

        setting_bottom();

    }

    public void setting(){
        alarm=findViewById(R.id.alarm);
        container=findViewById(R.id.container);
        bottom=findViewById(R.id.bottomnavigation);
        bottom.getMenu().getItem(0).setChecked(true);
        home=new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, home).commit();
    }

    public void setting_bottom(){
        bottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int select=item.getItemId();
                switch(select){
                    case R.id.home:
                        if(home==null){
                            home=new HomeFragment();
                            getSupportFragmentManager().beginTransaction().add(R.id.container, home).commit();
                        }
                        if(home!=null){
                            getSupportFragmentManager().beginTransaction().show(home).commit();
                        }
                        if(like!=null){
                            getSupportFragmentManager().beginTransaction().hide(like).commit();
                        }
                        if(mypage!=null){
                            getSupportFragmentManager().beginTransaction().hide(mypage).commit();
                        }
                        break;
                    case R.id.like:
                        if(like==null){
                            like=new LikeFragment();
                            getSupportFragmentManager().beginTransaction().add(R.id.container, like).commit();
                        }
                        if(like!=null){
                            getSupportFragmentManager().beginTransaction().show(like).commit();
                        }
                        if(home!=null){
                            getSupportFragmentManager().beginTransaction().hide(home).commit();
                        }
                        if(mypage!=null){
                            getSupportFragmentManager().beginTransaction().hide(mypage).commit();
                        }
                        break;
                    case R.id.mypage:
                        if(mypage==null){
                            mypage=new MypageFragment();
                            getSupportFragmentManager().beginTransaction().add(R.id.container, mypage).commit();
                        }
                        if(mypage!=null){
                            getSupportFragmentManager().beginTransaction().show(mypage).commit();
                        }
                        if(home!=null){
                            getSupportFragmentManager().beginTransaction().hide(home).commit();
                        }
                        if(like!=null){
                            getSupportFragmentManager().beginTransaction().hide(like).commit();
                        }
                        break;
                }
                return true;
            }
        });
    }
}