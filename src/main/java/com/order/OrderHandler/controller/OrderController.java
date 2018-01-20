package com.order.OrderHandler.controller;


import com.order.OrderHandler.AppConfig;
import com.order.OrderHandler.OrderHandlerApplication;
import com.order.OrderHandler.dto.BooleanPOJO;
import com.order.OrderHandler.dto.OrderDTO;
import com.order.OrderHandler.dto.OrderPostRequestDTO;
import com.order.OrderHandler.entity.CustomerInfo;
import com.order.OrderHandler.entity.Order;
import com.order.OrderHandler.entity.OrderIdentity;
import com.order.OrderHandler.entity.ProductOrder;
import com.order.OrderHandler.service.OrderService;
import com.order.OrderHandler.service.OrderServiceMail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderServiceMail orderServiceMail;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/getAllByUserId/{userId}")
    public ResponseEntity<?> getAllByUserId(@PathVariable("userId") String userId) {
        List<Order> order = orderService.getAllByUserId(userId);
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for (Order c : order) {
            OrderDTO orderDTO = new OrderDTO();
            if (order == null) {
                return new ResponseEntity<String>("", HttpStatus.OK);
            }
            BeanUtils.copyProperties(c, orderDTO);
            orderDTOS.add(orderDTO);
        }

        return new ResponseEntity<List<OrderDTO>>(orderDTOS, HttpStatus.OK);

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/generateOrder")
    public ResponseEntity<?> addOrUpdateEmployee(@RequestBody List<OrderPostRequestDTO> cartDTO) {
        //System.out.println(employeeDTO);
        HashMap<String, List<OrderPostRequestDTO>> orderMapping = new HashMap<>();
        for (OrderPostRequestDTO cart : cartDTO) {
            if (orderMapping.containsKey(cart.getSellerId())) {
                List<OrderPostRequestDTO> list = orderMapping.get(cart.getSellerId());
                list.add(cart);
                orderMapping.put(cart.getSellerId(), list);
            } else {
                List<OrderPostRequestDTO> list = new ArrayList<>();
                list.add(cart);
                orderMapping.put(cart.getSellerId(), list);
            }
        }
        for (String seller_id : orderMapping.keySet()) {
            List<OrderPostRequestDTO> listOrder = orderMapping.get(seller_id);
            synchronized (listOrder) {
                String timestamp = System.currentTimeMillis() + "";
                for (OrderPostRequestDTO order : listOrder) {
                    Order saveOrder = new Order();
                    OrderDTO data = new OrderDTO(new OrderIdentity(timestamp, order.getProductId()), order.getPrice(), order.getSellerId(), timestamp, order.getProductName(), order.getUserId(), "normal", "COD", order.getSellerName(), order.getImageUrl(), order.getQuantity());
                    System.out.println(data.toString());
                    BeanUtils.copyProperties(data, saveOrder);
                    System.out.println(saveOrder.toString());
                    orderService.saveOrder(saveOrder);
                    ProductOrder orderMail = new ProductOrder();
                    orderMail.setOrderId(data.getOrderIdentity().getOrderId());
                    orderMail.setProductName(data.getProductName());
                    orderMail.setUserId(data.getUserId());
                    orderMail.setProductName(data.getProductName());
                    orderMail.setPrice(Integer.parseInt(data.getPrice() + ""));
                    order.setQuantity(data.getQuantity());
                    order.setSellerName(data.getSellerName());
                    CustomerInfo customerInfo = new CustomerInfo();

                    customerInfo.setEmail(data.getUserId());
                    orderMail.setCustomerInfo(customerInfo);
                    orderServiceMail.sendOrderConfirmation(orderMail);

                }
            }

        }
        // OrderGenerateDTO orderGenerateDTO = new OrderGenerateDTO();
        // OrderGenerate cart = new OrderGenerate();
        // cart.setCartIdentity(new CartIdentity(cartDTO.getCartIdentity().getCartId(),cartDTO.getCartIdentity().getProductId()));
        //cart.
        //BeanUtils.copyProperties(cartDTO, cart);
        //System.out.println(employee);
        //BooleanPOJO response=new BooleanPOJO();
        //response.setResponse(cartService.addToCart(cart));
        return new ResponseEntity<BooleanPOJO>(new BooleanPOJO(true), HttpStatus.CREATED);
    }
}


