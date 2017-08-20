package com.example.user.a6_dinamiclistitemexam.model;

/**
 * Created by user on 2017-08-20.
 */

public class Item {
    private int num;
    private String name;

    public Item(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
