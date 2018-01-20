package com.order.OrderHandler.service.impl;

import com.order.OrderHandler.entity.ProductOrder;
import com.order.OrderHandler.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service("mailService")
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender mailSender;

    @Override
    public void sendEmail(Object object) {

        ProductOrder order = (ProductOrder) object;

        MimeMessagePreparator preparator = getMessagePreparator(order);

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private MimeMessagePreparator getMessagePreparator(final ProductOrder order) {

        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(order.getUserId()));
                mimeMessage.setText("Dear " + "User"
                        + ", thank you for placing " + order.getProductName() + ",Your order id is EPO" + order.getOrderId() + "\n price is " + order.getPrice() );
                mimeMessage.setSubject("Your order on Electrokart");
            }
        };
        return preparator;
    }

}