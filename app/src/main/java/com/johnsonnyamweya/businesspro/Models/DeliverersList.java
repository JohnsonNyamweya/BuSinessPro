package com.johnsonnyamweya.businesspro.Models;

public class DeliverersList {

    public String name, phone, email, address, carBikeName;

    public DeliverersList() {
    }

    public DeliverersList(String name, String phone, String email, String address, String carBikeName) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.carBikeName = carBikeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCarBikeName() {
        return carBikeName;
    }

    public void setCarBikeName(String carBikeName) {
        this.carBikeName = carBikeName;
    }
}
