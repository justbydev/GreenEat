package com.zerowaste.greeneat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class Bowl_recommend extends AppCompatActivity {
    TextView menu_name, select_number, select_shape, select_temparature, select_sauce;
    TextView menu_bowl_recommend, menu_sauce_bowl_recommend;
    CardView menu_bowl_recommend_cardview, menu_sauce_bowl_recommend_cardview;
    Intent intent;
    static Context recommend_context;
    String num="옵션 선택", shape="옵션 선택", temparature="옵션 선택", sauce="옵션 선택";
    int int_num=0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bowl_recommend);

        setting();
        setlistener();
    }

    public void setting(){
        recommend_context=this;
        menu_name=findViewById(R.id.menu_name);
        select_number=findViewById(R.id.select_number);
        select_shape=findViewById(R.id.select_shape);
        select_temparature=findViewById(R.id.select_tempature);
        select_sauce=findViewById(R.id.select_sauce);
        menu_bowl_recommend=findViewById(R.id.menu_bowl_recommend);
        menu_sauce_bowl_recommend=findViewById(R.id.menu_sauce_bowl_recommend);
        menu_bowl_recommend_cardview=findViewById(R.id.menu_bowl_recommend_carview);
        menu_sauce_bowl_recommend_cardview=findViewById(R.id.menu_sauce_bowl_recommend_cardview);

        intent=getIntent();
        menu_name.setText(intent.getStringExtra("menu_name"));
    }

    public void setlistener(){
        select_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout dialog=(LinearLayout)View.inflate(recommend_context, R.layout.select_dialog, null);
                TextView select_button=dialog.findViewById(R.id.select_button);
                final RadioGroup select_radiogroup=dialog.findViewById(R.id.select_radiogroup);
                final ArrayList<String> number=new ArrayList<>();
                number.add("옵션 선택"); number.add("1개"); number.add("2개"); number.add("3개"); number.add("4개");
                for(int i=0; i<=4; i++){
                    RadioButton radioButton=new RadioButton(recommend_context);
                    radioButton.setText(number.get(i));
                    radioButton.setId(i);
                    RadioGroup.LayoutParams rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    select_radiogroup.addView(radioButton, rprms);
                }
                final AlertDialog numberdialog=new AlertDialog.Builder(recommend_context)
                        .setView(dialog)
                        .create();
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int Id=select_radiogroup.getCheckedRadioButtonId();
                        for(int i=0; i<=4; i++){
                            if(Id==i){
                                num=number.get(i);
                                int_num=i;
                                break;
                            }
                        }
                        check_for_main_recommend();
                        select_number.setText(num);
                        numberdialog.dismiss();
                    }
                });
                numberdialog.show();
            }
        });
        select_shape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout dialog=(LinearLayout)View.inflate(recommend_context, R.layout.select_dialog, null);
                TextView select_button=dialog.findViewById(R.id.select_button);
                final RadioGroup select_radiogroup=dialog.findViewById(R.id.select_radiogroup);
                final ArrayList<String> shape_list=new ArrayList<>();
                shape_list.add("옵션 선택"); shape_list.add("원형"); shape_list.add("사각형");
                for(int i=0; i<=2; i++){
                    RadioButton radioButton=new RadioButton(recommend_context);
                    radioButton.setText(shape_list.get(i));
                    radioButton.setId(i);
                    RadioGroup.LayoutParams rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    select_radiogroup.addView(radioButton, rprms);
                }
                final AlertDialog shapedialog=new AlertDialog.Builder(recommend_context)
                        .setView(dialog)
                        .create();
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int Id=select_radiogroup.getCheckedRadioButtonId();
                        for(int i=0; i<=2; i++){
                            if(Id==i){
                                shape=shape_list.get(i);
                                break;
                            }
                        }
                        check_for_main_recommend();
                        select_shape.setText(shape);
                        shapedialog.dismiss();
                    }
                });
                shapedialog.show();
            }
        });
        select_temparature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout dialog=(LinearLayout)View.inflate(recommend_context, R.layout.select_dialog, null);
                TextView select_button=dialog.findViewById(R.id.select_button);
                final RadioGroup select_radiogroup=dialog.findViewById(R.id.select_radiogroup);
                final ArrayList<String> temp_list=new ArrayList<>();
                temp_list.add("옵션 선택"); temp_list.add("뜨겁게"); temp_list.add("차갑게"); temp_list.add("해당 없음");
                for(int i=0; i<=3; i++){
                    RadioButton radioButton=new RadioButton(recommend_context);
                    radioButton.setText(temp_list.get(i));
                    radioButton.setId(i);
                    RadioGroup.LayoutParams rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    select_radiogroup.addView(radioButton, rprms);
                }
                final AlertDialog temparaturedialog=new AlertDialog.Builder(recommend_context)
                        .setView(dialog)
                        .create();
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int Id=select_radiogroup.getCheckedRadioButtonId();
                        for(int i=0; i<=3; i++){
                            if(Id==i){
                                temparature=temp_list.get(i);
                                break;
                            }
                        }
                        select_temparature.setText(temparature);
                        temparaturedialog.dismiss();
                    }
                });
                temparaturedialog.show();
            }
        });
        select_sauce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout dialog=(LinearLayout)View.inflate(recommend_context, R.layout.select_dialog, null);
                TextView select_button=dialog.findViewById(R.id.select_button);
                final RadioGroup select_radiogroup=dialog.findViewById(R.id.select_radiogroup);
                final ArrayList<String> sauce_list=new ArrayList<>();
                sauce_list.add("옵션 선택"); sauce_list.add("Yes"); sauce_list.add("No");
                for(int i=0; i<=2; i++){
                    RadioButton radioButton=new RadioButton(recommend_context);
                    radioButton.setText(sauce_list.get(i));
                    radioButton.setId(i);
                    RadioGroup.LayoutParams rprms= new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT);
                    select_radiogroup.addView(radioButton, rprms);
                }
                final AlertDialog saucedialog=new AlertDialog.Builder(recommend_context)
                        .setView(dialog)
                        .create();
                select_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int Id=select_radiogroup.getCheckedRadioButtonId();
                        for(int i=0; i<=2; i++){
                            if(Id==i){
                                sauce=sauce_list.get(i);
                                break;
                            }
                        }
                        check_for_sauce_recommend();
                        select_sauce.setText(sauce);
                        saucedialog.dismiss();
                    }
                });
                saucedialog.show();
            }
        });
    }

    public void check_for_main_recommend(){
        if(num.equals("옵션 선택")||shape.equals("옵션 선택")){
            menu_bowl_recommend_cardview.setVisibility(View.GONE);
            menu_bowl_recommend.setVisibility(View.GONE);
            return;
        }
        menu_bowl_recommend_cardview.setVisibility(View.VISIBLE);
        menu_bowl_recommend.setVisibility(View.VISIBLE);
        int gr_garo=15;
        int sr_garo=15;
        int gr_sero=10;
        int sr_sero=10;
        int gr_height=7;
        int sr_height=7;
        if(int_num==2){
            gr_garo=gr_garo*2;
            sr_height=sr_height*2;
        }
        else if(int_num==3){
            gr_garo=gr_garo*2;
            gr_sero=gr_sero*2;
            sr_height=sr_height*3;
        }
        else if(int_num==4){
            gr_garo=gr_garo*2;
            gr_sero=gr_sero*2;
            sr_height=sr_height*4;
        }
        String garo_recommend="가로추천\n가로x "+ gr_garo+"cm\n세로x "+gr_sero+"cm\n높이x "+gr_height+"cm\n\n";
        String sero_recommend="세로추천\n가로x "+sr_garo+"cm\n세로x "+sr_sero+"cm\n높이x "+sr_height+"cm\n";
        String shape_recommend=shape+" 용기";
        String recommend=garo_recommend+sero_recommend+shape_recommend;
        menu_bowl_recommend.setText(recommend);
    }

    public void check_for_sauce_recommend(){
        if(sauce.equals("옵션 선택")||sauce.equals("No")){
            menu_sauce_bowl_recommend_cardview.setVisibility(View.GONE);
            menu_sauce_bowl_recommend.setVisibility(View.GONE);
            return;
        }
        menu_sauce_bowl_recommend_cardview.setVisibility(View.VISIBLE);
        menu_sauce_bowl_recommend.setVisibility(View.VISIBLE);
        int garo=5;
        int sero=5;
        int height=3;
        String recommend="추천\n가로x "+ garo+"cm\n세로x "+sero+"cm\n높이x "+height+"cm";
        menu_sauce_bowl_recommend.setText(recommend);
    }
}
