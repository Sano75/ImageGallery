package com.example.imagegallery;

public class Image {
    private int id;
    private String describe;
    private byte[] image;

    public Image(String describe, byte[] image, int id) {
        this.describe = describe;
        this.image = image;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String name) {
        this.describe = describe;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
