package com.realdolmen.jxp010.domain;

public class Movie {
    private String title;
    private String type;
    private String format;

    public Movie(String title, String genre, String format) {
        this.title = title;
        this.type = genre;
        this.format = format;
    }

    public Movie() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
