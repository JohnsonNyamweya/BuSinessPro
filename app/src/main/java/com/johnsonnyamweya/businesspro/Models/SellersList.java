package com.johnsonnyamweya.businesspro.Models;

public class SellersList {

    private String sellerListName, sellerListPhone, sellerListEmail, sellerListAddress;

    public SellersList() {
    }

    public SellersList(String sellerListName, String sellerListPhone, String sellerListEmail, String sellerListAddress) {
        this.sellerListName = sellerListName;
        this.sellerListPhone = sellerListPhone;
        this.sellerListEmail = sellerListEmail;
        this.sellerListAddress = sellerListAddress;
    }

    public String getSellerListName() {
        return sellerListName;
    }

    public void setSellerListName(String sellerListName) {
        this.sellerListName = sellerListName;
    }

    public String getSellerListPhone() {
        return sellerListPhone;
    }

    public void setSellerListPhone(String sellerListPhone) {
        this.sellerListPhone = sellerListPhone;
    }

    public String getSellerListEmail() {
        return sellerListEmail;
    }

    public void setSellerListEmail(String sellerListEmail) {
        this.sellerListEmail = sellerListEmail;
    }

    public String getSellerListAddress() {
        return sellerListAddress;
    }

    public void setSellerListAddress(String sellerListAddress) {
        this.sellerListAddress = sellerListAddress;
    }
}
