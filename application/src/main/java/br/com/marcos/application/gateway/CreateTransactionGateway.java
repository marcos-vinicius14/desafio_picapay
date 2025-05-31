package br.com.marcos.application.gateway;

import br.marcos.core.domain.Transaction;


public interface CreateTransactionGateway {
    Transaction create(Transaction transaction) throws Exception;
}
