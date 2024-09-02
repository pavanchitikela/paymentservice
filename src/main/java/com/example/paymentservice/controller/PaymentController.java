package com.example.paymentservice.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class PaymentController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);
    @PostMapping("/pay")
    public String doPayment(@RequestBody Long orderId) throws InterruptedException {

        String response = "";
        if(orderId > 100) Thread.sleep(10000);
        else{
            response = "Payment is done, and order is placed";
        }
        return response;
    }

}
