package com.example.demo.entities;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("id")
    private Long id;

    @SerializedName("address")
    private String address;

    public Address() {
    }

    public Address(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
