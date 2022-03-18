package com.example.demo.entities;

import com.google.gson.annotations.SerializedName;


public class UserAccount {


    @SerializedName("id")
    private Long id;

    @SerializedName("userName")
    private String userName;

    @SerializedName("passWord")
    private String passWord;

    @SerializedName("status")
    private Boolean status;

    public UserAccount(Long id, String userName, String passWord, Boolean status) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.status = status;
    }

    public UserAccount() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
