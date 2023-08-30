package com.kafein.intern.postinger_bank_service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.Objects;


@Data
public class Request {
    private Long walletId;
    private double amount;

    @ConstructorProperties({"walletId", "amount"})
    public Request(Long walletId, double amount) {
        super();
        this.walletId = walletId;
        this.amount = amount;
    }
}
