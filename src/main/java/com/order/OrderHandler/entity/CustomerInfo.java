package com.order.OrderHandler.entity;

public class CustomerInfo {


    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "email='" + email + '\'' +
                '}';
    }
}
