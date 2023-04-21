package com.example.vapor;

public class Game {

    private int mIconResourceId;
    private String mTitle;
    private String mDescription;
    private double mPrice;

    public Game(int iconResourceId, String title, String description, double price) {
        mIconResourceId = iconResourceId;
        mTitle = title;
        mDescription = description;
        mPrice = price;
    }

    public int getIconResourceId() {
        return mIconResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    // ...
}