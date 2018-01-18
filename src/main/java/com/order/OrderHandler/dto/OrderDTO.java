package com.order.OrderHandler.dto;

import com.order.OrderHandler.entity.OrderIdentity;

import javax.persistence.Id;

public class OrderDTO {

    OrderIdentity orderIdentity;
    long price;
    String sellerId;
    String timeStamp;
    String productName;
    String userId;
    String shipmentMethod;
    String paymentMethod;
    String sellerName;
String imageUrl;
int quantity;

    public OrderDTO() {
    }

    public OrderDTO(OrderIdentity orderIdentity, long price, String sellerId, String timeStamp, String productName, String userId, String shipmentMethod, String paymentMethod, String sellerName, String imageUrl, int quantity) {
        this.orderIdentity = orderIdentity;
        this.price = price;
        this.sellerId = sellerId;
        this.timeStamp = timeStamp;
        this.productName = productName;
        this.userId = userId;
        this.shipmentMethod = shipmentMethod;
        this.paymentMethod = paymentMethod;
        this.sellerName = sellerName;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderIdentity getOrderIdentity() {
        return orderIdentity;
    }

    public void setOrderIdentity(OrderIdentity orderIdentity) {
        this.orderIdentity = orderIdentity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderIdentity=" + orderIdentity +
                ", price=" + price +
                ", sellerId='" + sellerId + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", productName='" + productName + '\'' +
                ", userId='" + userId + '\'' +
                ", shipmentMethod='" + shipmentMethod + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", sellerName='" + sellerName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShipmentMethod() {
        return shipmentMethod;
    }

    public void setShipmentMethod(String shipmentMethod) {
        this.shipmentMethod = shipmentMethod;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
