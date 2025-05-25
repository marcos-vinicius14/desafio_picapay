package br.com.marcos.usecase;

import br.marcos.core.domain.TransactionPin;

public interface TransactionPinValidateCase {
    Boolean validate(TransactionPin transactionPin);
}
