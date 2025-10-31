package com.pragyan.service;

import com.razorpay.*;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {
    @Value("${razorpay.key_id}") private String keyId;
    @Value("${razorpay.key_secret}") private String keySecret;
    public Order createOrder(int amount, String currency, String receipt) throws Exception {
        RazorpayClient client = new RazorpayClient(keyId, keySecret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amount * 100);
        orderRequest.put("currency", currency);
        orderRequest.put("receipt", receipt);
        return client.orders.create(orderRequest);
    }
    public boolean verifySignature(String orderId, String paymentId, String signature) {
        try { return com.razorpay.Utils.verifySignature(orderId + "|" + paymentId, signature, keySecret); }
        catch(Exception ex){ return false; }
    }
}
