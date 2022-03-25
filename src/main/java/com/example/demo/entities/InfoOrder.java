package com.example.demo.entities;

import java.util.Date;

public class InfoOrder {

    private Long idAddress;

    private Long idCustomer;

    private Date date;

    public InfoOrder(Long idAddress, Long idCustomer, Date date) {
        this.idAddress = idAddress;
        this.idCustomer = idCustomer;
        this.date = date;
    }

    public InfoOrder() {
    }

    public Long getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Long idAddress) {
        this.idAddress = idAddress;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "InfoOrder{" +
                "idAddress=" + idAddress +
                ", idCustomer=" + idCustomer +
                ", date=" + date +
                '}';
    }
}
