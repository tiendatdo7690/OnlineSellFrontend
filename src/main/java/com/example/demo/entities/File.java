package com.example.demo.entities;

import com.google.gson.annotations.SerializedName;

public class File {

    @SerializedName("file")
    private byte[] file;
    @SerializedName("name")
    private String name;

    public File() {
    }

    public File(byte[] file, String name) {
        this.file = file;
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
