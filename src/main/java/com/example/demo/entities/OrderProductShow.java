package com.example.demo.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderProductShow {

    @SerializedName("id")
    private Long id;

    @SerializedName("date")
    private Date date;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("nameProduct")
    private String nameProduct;

    @SerializedName("idCustomer")
    private Long idCustomer;

    @SerializedName("address")
    private String address;

    @SerializedName("success")
    private Boolean success;

    public OrderProductShow() {
    }

    public OrderProductShow(Long id, Date date, int quantity, String nameProduct, Long idCustomer, String address, Boolean success) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.nameProduct = nameProduct;
        this.idCustomer = idCustomer;
        this.address = address;
        this.success = success;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
