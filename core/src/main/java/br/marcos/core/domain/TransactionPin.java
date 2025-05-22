package br.marcos.core.domain;

import java.time.LocalDateTime;

public class TransactionPin {
    private Long pinId;
    private  User user;
    private String pin;
    private Integer attempt;
    private Boolean isBlocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TransactionPin() {
    }

    public TransactionPin(User user, String pin, Boolean isBlocked, Integer attempt) {
        this.user = user;
        this.pin = pin;
        this.isBlocked = isBlocked;
        this.attempt = attempt;
    }

    public TransactionPin(User user, Long pinId, String pin, Integer attempt, Boolean isBlocked, LocalDateTime updatedAt) {
        this.user = user;
        this.pinId = pinId;
        this.pin = pin;
        this.attempt = attempt;
        this.isBlocked = isBlocked;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }


}
