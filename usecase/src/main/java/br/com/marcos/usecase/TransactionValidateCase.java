package br.com.marcos.usecase;

import br.marcos.core.domain.Transaction;
import br.marcos.core.domain.exceptions.TransferException;

public interface TransactionValidateCase {
    Boolean validate (Transaction transaction) throws TransferException;
}
