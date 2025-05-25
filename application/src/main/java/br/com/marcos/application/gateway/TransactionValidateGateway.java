package br.com.marcos.application.gateway;

import br.marcos.core.domain.Transaction;

public interface TransactionValidateGateway {
    Boolean validate(Transaction transaction);
}
