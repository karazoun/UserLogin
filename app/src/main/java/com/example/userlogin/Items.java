package com.example.userlogin;

public class Items {
    String name;
    String brief;
    int image;

    public Items(String name, String brief, int image) {
        this.name = name;
        this.brief = brief;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
