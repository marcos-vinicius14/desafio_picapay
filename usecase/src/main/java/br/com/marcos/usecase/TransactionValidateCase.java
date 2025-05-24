package br.com.marcos.usecase;

import br.marcos.core.domain.Transaction;

public interface TransactionValidateCase {
    Boolean validate (Transaction transaction);
}
