package com.order.OrderHandler.service.impl;

import com.order.OrderHandler.entity.Order;
import com.order.OrderHandler.repository.OrderRepository;
import com.order.OrderHandler.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllByUserId(String userId) {
        return orderRepository.findByUserIdOrderByOrderIdentityOrderIdDesc(userId);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
