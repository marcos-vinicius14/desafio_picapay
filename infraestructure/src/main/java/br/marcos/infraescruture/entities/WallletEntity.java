package br.marcos.infraescruture.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_wallet")
@Data
public class WallletEntity {
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    @Column(name = "pin")
    private String pin;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_pin_id", referencedColumnName = "id")
    private TransactionPinEntity transactionPinEntity;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


    public WallletEntity(BigDecimal balance, UserEntity user, TransactionPinEntity transactionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
    }

    public WallletEntity(BigDecimal balance, UserEntity user, String pin, LocalDateTime updatedAt, LocalDateTime createdAt) {
        this.balance = balance;
        this.user = user;
        this.pin = pin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public WallletEntity() {
    }



    public TransactionPinEntity getTransactionPinEntity() {
        return transactionPinEntity;
    }

    public int getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
