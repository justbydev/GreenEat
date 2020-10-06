package com.zerowaste.greeneat;

import java.util.ArrayList;

public class Shop_Info {
    String shop_name;
    String shop_address;
    String shop_category;
    ArrayList<String> menu_name;

    public Shop_Info(String name, String address, String cat, ArrayList<String> menu){
        this.shop_name=name;
        this.shop_address=address;
        this.shop_category=cat;
        this.menu_name=menu;
    }
    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getShop_category() {
        return shop_category;
    }

    public void setShop_category(String shop_category) {
        this.shop_category = shop_category;
    }

    public ArrayList<String> getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(ArrayList<String> menu_name) {
        this.menu_name = menu_name;
    }
}
