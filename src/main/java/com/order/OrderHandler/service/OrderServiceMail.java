package com.order.OrderHandler.service;

import com.order.OrderHandler.entity.ProductOrder;

public interface OrderServiceMail {
    public void sendOrderConfirmation(ProductOrder productOrder);
}
