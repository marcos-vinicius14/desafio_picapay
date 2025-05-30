package br.marcos.core.domain;

import br.marcos.core.domain.enums.UserType;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String password;
    private TaxNumber taxNumber;
    private String fullName;
    private UserType type;
    private TransactionPin transactionPin;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(String email, String password, TaxNumber taxNumber, String fullName, UserType type, TransactionPin transactionPin) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
    }

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserType type, TransactionPin transactionPin, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = updatedAt;
    }

    public User(UUID id, String email, String password, TaxNumber taxNumber, String fullName, UserType type, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.taxNumber = taxNumber;
        this.fullName = fullName;
        this.type = type;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public TaxNumber getTaxNumber() {
        return taxNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public UserType getType() {
        return type;
    }

    public TransactionPin getTransactionPin() {
        return transactionPin;
    }

    public void transactionPinIsValid(String transactionPin) {
        if (transactionPin.length() != 8) {
            throw new IllegalArgumentException('\'' + transactionPin + "' is not a valid transaction pin");
        }
    }

    public void setTransactionPin(TransactionPin transactionPin) {
        transactionPinIsValid(transactionPin.toString());
        this.transactionPin = transactionPin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(taxNumber, user.taxNumber) && Objects.equals(fullName, user.fullName) && type == user.type && Objects.equals(transactionPin, user.transactionPin) && Objects.equals(createdAt, user.createdAt) && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, taxNumber, fullName, type, transactionPin, createdAt, updatedAt);
    }
}
