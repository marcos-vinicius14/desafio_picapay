package br.com.marcos.application.gateway;

import br.marcos.core.domain.TransactionPin;

import java.io.IOException;

public interface TransactionPinValidateGateway {
    Boolean validate(TransactionPin transactionPin) throws IOException, InterruptedException;
}
