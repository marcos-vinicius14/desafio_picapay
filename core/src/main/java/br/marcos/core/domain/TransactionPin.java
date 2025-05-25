package br.marcos.core.domain;

import br.marcos.core.domain.exceptions.TransactionPinException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

import java.time.LocalDateTime;
import java.util.Objects;

public class TransactionPin {
    private Long pinId;
    private String pin;
    private Integer attempt;
    private Boolean isBlocked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public TransactionPin() {
    }



    public TransactionPin(String pin) throws TransactionPinException {
        setPin(pin);
        this.isBlocked = false;
        this.attempt = 3;
    }

    public TransactionPin(Long pinId, String pin, Integer attempt, Boolean isBlocked, LocalDateTime updatedAt) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TransactionPin that = (TransactionPin) o;
        return Objects.equals(pinId, that.pinId) && Objects.equals(pin, that.pin) && Objects.equals(attempt, that.attempt) && Objects.equals(isBlocked, that.isBlocked) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pinId, pin, attempt, isBlocked, createdAt, updatedAt);
    }
}
