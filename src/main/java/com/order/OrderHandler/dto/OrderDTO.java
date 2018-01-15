package com.order.OrderHandler.dto;

import java.util.Date;
import java.util.Map;

public class OrderDTO {
    private String orderId;
    private Map<ProductDetailsDTO,Integer> productList;
private String sellerId;
private String userId;
private BillDTO orderBill;
private String shipmentAddress;
private String trackId;
    private String shipmentMethod;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<ProductDetailsDTO, Integer> getProductList() {
        return productList;
    }

    public void setProductList(Map<ProductDetailsDTO, Integer> productList) {
        this.productList = productList;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BillDTO getOrderBill() {
        return orderBill;
    }

    public void setOrderBill(BillDTO orderBill) {
        this.orderBill = orderBill;
    }

    public String getShipmentAddress() {
        return shipmentAddress;
    }

    public void setShipmentAddress(String shipmentAddress) {
        this.shipmentAddress = shipmentAddress;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
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

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private String paymentMethod;
    private Date orderDate;
}
