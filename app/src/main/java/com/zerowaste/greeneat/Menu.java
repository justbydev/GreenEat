package com.zerowaste.greeneat;

public class Menu {
    int image;
    String menu_name;
    public Menu(int image, String menu_name){
        this.image=image;
        this.menu_name=menu_name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }
}
