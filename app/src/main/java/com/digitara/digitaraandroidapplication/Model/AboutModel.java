package com.digitara.digitaraandroidapplication.Model;

public class AboutModel {
    String Description;
    int ScreenImg;
    String Title;

    public AboutModel(String title, String description, int screenImg) {
        this.Title = title;
        this.Description = description;
        this.ScreenImg = screenImg;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getScreenImg() {
        return this.ScreenImg;
    }

    public void setScreenImg(int screenImg) {
        this.ScreenImg = screenImg;
    }
}
