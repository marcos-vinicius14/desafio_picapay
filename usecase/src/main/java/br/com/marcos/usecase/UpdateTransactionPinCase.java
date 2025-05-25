package br.com.marcos.usecase;

import br.marcos.core.domain.TransactionPin;

public interface UpdateTransactionPinCase {
    TransactionPin update(TransactionPin transactionPin);
}
