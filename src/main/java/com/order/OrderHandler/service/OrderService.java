package com.order.OrderHandler.service;

import com.order.OrderHandler.entity.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllByUserId(String userId);

    public void saveOrder(Order order);
}
