package com.kafein.intern.postinger_bank_service.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class PaymentResponse implements Serializable {
    private Long walletId;
    private String message;
    public PaymentResponse(Long walletId, String message) {
        super();
        this.walletId = walletId ;
        this.message = message;
    }
}