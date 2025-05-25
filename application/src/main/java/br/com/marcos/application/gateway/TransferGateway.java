package br.com.marcos.application.gateway;

import br.marcos.core.domain.Transaction;

public interface TransferGateway {
    Boolean transfer(Transaction transaction);
}
