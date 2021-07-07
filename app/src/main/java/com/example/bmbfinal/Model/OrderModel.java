package com.example.bmbfinal.Model;

import java.util.Date;

public class OrderModel {
    private Integer id;
    private String Description;
    private Integer ClientID;
    private Date OrderDate;
    private Long OrderAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Integer getClientID() {
        return ClientID;
    }

    public void setClientID(Integer clientID) {
        ClientID = clientID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date orderDate) {
        OrderDate = orderDate;
    }

    public Long getOrderAmount() {
        return OrderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        OrderAmount = orderAmount;
    }
}
