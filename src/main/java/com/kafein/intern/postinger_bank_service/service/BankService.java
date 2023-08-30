package com.kafein.intern.postinger_bank_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafein.intern.postinger_bank_service.model.PaymentResponse;
import com.kafein.intern.postinger_bank_service.model.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BankService {
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "withdrawalRequests")
    public void processWithdrawalRequest(String request) throws JsonProcessingException {
        System.out.println(request);
        ObjectMapper objectMapper = new ObjectMapper();
        Request payload = objectMapper.readValue(request, Request.class);

        System.out.println("Message received");
        System.out.println("WalletId:    " + payload.getWalletId());
        System.out.println("Amount:     " + payload.getAmount());
        PaymentResponse response = new PaymentResponse(payload.getWalletId(), "Withdrawal successful");
        ObjectMapper objectMapper1 = new ObjectMapper();
        String queuePayloadString = objectMapper1.writeValueAsString(response);
        System.out.println(queuePayloadString);
        rabbitTemplate.convertAndSend("paymentResponseWithdrawal", queuePayloadString);
    }

    @RabbitListener(queues = "depositRequests")
    public void processDepositRequest(String request) throws JsonProcessingException {
        System.out.println(request);
        ObjectMapper objectMapper = new ObjectMapper();
        Request payload = objectMapper.readValue(request, Request.class);

        System.out.println("Message received");
        System.out.println("WalletId:    " + payload.getWalletId());
        System.out.println("Amount:     " + payload.getAmount());
        PaymentResponse response = new PaymentResponse(payload.getWalletId(), "Deposit successful");
        ObjectMapper objectMapper1 = new ObjectMapper();
        String queuePayloadString = objectMapper1.writeValueAsString(response);
        System.out.println(queuePayloadString);
        rabbitTemplate.convertAndSend("paymentResponseDeposit", queuePayloadString);
    }
}
