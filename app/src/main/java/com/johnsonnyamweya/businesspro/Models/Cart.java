package com.johnsonnyamweya.businesspro.Models;

public class Cart {

    private String pid, pName, price, quantity;

    public Cart() {

    }

    public Cart(String pid, String pName, String price, String quantity) {
        this.pid = pid;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
