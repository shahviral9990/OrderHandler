package com.order.OrderHandler.repository;

import com.order.OrderHandler.entity.Order;
import com.order.OrderHandler.entity.OrderIdentity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, OrderIdentity> {
    //  @Query( "select o from Order o where userId :userId" )
    public List<Order> findByUserIdOrderByOrderIdentityOrderIdDesc(String userId);
}
