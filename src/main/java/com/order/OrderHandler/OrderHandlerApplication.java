package com.order.OrderHandler;

import com.order.OrderHandler.service.OrderServiceMail;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class OrderHandlerApplication {
    //public static AbstractApplicationContext context;
    public static void main(String[] args) {
        SpringApplication.run(OrderHandlerApplication.class, args);
        //	context = new AnnotationConfigApplicationContext(AppConfig.class);
        //AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    }
}
