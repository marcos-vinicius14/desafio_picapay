package br.com.marcos.application.gateway;

import br.marcos.core.domain.TransactionPin;

public interface CreateTransactionPinCaseGateway {
    void create(TransactionPin transactionPin);
}
