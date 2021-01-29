package com.digitara.digitaraandroidapplication.Model;

public class TeamModel {
    String Description;
    int ProfileImg;

    public TeamModel(String description, int profileImg) {
        this.Description = description;
        this.ProfileImg = profileImg;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public int getProfileImg() {
        return this.ProfileImg;
    }

    public void setProfileImg(int profileImg) {
        this.ProfileImg = profileImg;
    }
}
