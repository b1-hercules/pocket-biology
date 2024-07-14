package com.adi.mediapembelajaranmatematika.Models;

import android.graphics.drawable.Drawable;

public class MateriModels {
    private Integer icon;
    private String title,  link;

    public MateriModels(String title, Integer icon, String link) {
        this.title = title;
        this.icon = icon;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
