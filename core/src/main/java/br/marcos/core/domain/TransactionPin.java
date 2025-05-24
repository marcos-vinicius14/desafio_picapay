package br.marcos.core.domain;

import br.marcos.core.domain.exceptions.TransactionPinException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

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



    public TransactionPin(User user, String pin) throws TransactionPinException {
        this.user = user;
        setPin(pin);
        this.isBlocked = false;
        this.attempt = 3;
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

    public Long getPinId() {
        return pinId;
    }

    public void pinIsValid(String pin) throws TransactionPinException {
        if (pin.length() != 8) {
            throw new TransactionPinException(ErroCodeEnum.TRP001.getMessage(), ErroCodeEnum.TRP001.getCode() );
        }
    }

    public void setPinId(Long pinId) {
        this.pinId = pinId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) throws TransactionPinException {
        pinIsValid(pin);
        this.pin = pin;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
