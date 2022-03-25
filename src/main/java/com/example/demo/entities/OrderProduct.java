package com.example.demo.entities;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class OrderProduct {

    @SerializedName("id")
    private Long id;

    @SerializedName("date")
    private Date date;

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("idProduct")
    private Long idProduct;

    @SerializedName("idCustomer")
    private Long idCustomer;

    @SerializedName("idAddress")
    private Long idAddress;

    public OrderProduct(Long id, Date date, int quantity, Long idProduct, Long idCustomer, Long idAddress) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idCustomer = idCustomer;
        this.idAddress = idAddress;
    }

    public OrderProduct() {
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

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }
}
