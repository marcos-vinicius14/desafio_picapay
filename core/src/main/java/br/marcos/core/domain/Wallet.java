package br.marcos.core.domain;

import br.marcos.core.domain.enums.UserType;
import br.marcos.core.domain.exceptions.TransferException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Wallet {
    private Long id;
    private BigDecimal balance;
    private User user;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private TransactionPin transactionPin;

    public Wallet() {
    }

    public Wallet(User user, BigDecimal balance, TransactionPin transactionPin) {
        this.user = user;
        this.balance = balance;
        this.transactionPin = transactionPin;

    }

    public Wallet(Long id, BigDecimal balance, User user, LocalDateTime updatedAt, TransactionPin transactionPin) {
        this.id = id;
        this.balance = balance;
        this.user = user;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
        this.transactionPin = transactionPin;
    }

    public Wallet(TransactionPin transactionPin, BigDecimal zero) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void receiveValue(BigDecimal value) {
        this.balance.add(value);
    }

    public void transfer(BigDecimal amount) throws TransferException {
        if (this.user.getType() == UserType.SHOPKEEPER) {
            throw new TransferException(ErroCodeEnum.TR0001.getMessage(), ErroCodeEnum.TR0001.getCode());
        }

        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new TransferException(ErroCodeEnum.TR0002.getMessage(), ErroCodeEnum.TR0002.getCode());
        }

        this.balance.subtract(amount);
    }

    public void receiveTransfer(BigDecimal value) {
        this.balance.add(value);
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        this.transactionPin = transactionPin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Wallet wallet = (Wallet) o;
        return Objects.equals(balance, wallet.balance) && Objects.equals(user, wallet.user) && Objects.equals(createdAt, wallet.createdAt) && Objects.equals(updatedAt, wallet.updatedAt) && Objects.equals(transactionPin, wallet.transactionPin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance, user, createdAt, updatedAt, transactionPin);
    }
}
