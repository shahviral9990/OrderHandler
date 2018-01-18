package com.order.OrderHandler.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
public class OrderIdentity implements Serializable {
    @NotNull
    private String orderId;
    @NotNull
    private String productId;

    public String getOrderId() {
        return orderId;
    }

    public OrderIdentity() {
    }

    public OrderIdentity(String orderId, String productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
