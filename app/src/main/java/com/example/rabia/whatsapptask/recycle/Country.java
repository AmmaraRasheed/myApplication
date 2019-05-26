package com.example.rabia.whatsapptask.recycle;

import android.widget.Toast;

public class Country {

    private String name;
    private String capital;
    private String area;
    private int image;
    private boolean isSelect=false;

    public Country() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isSelect() {

        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
