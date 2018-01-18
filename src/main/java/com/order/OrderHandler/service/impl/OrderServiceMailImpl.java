package com.order.OrderHandler.service.impl;

import com.order.OrderHandler.entity.ProductOrder;
import com.order.OrderHandler.service.MailService;
import com.order.OrderHandler.service.OrderServiceMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderServiceMail")
public class OrderServiceMailImpl implements OrderServiceMail {

    @Autowired
    MailService mailService;

    @Override
    public void sendOrderConfirmation(ProductOrder productOrder) {
        mailService.sendEmail(productOrder);
    }

}
