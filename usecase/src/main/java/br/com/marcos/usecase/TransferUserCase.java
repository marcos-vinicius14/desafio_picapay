package br.com.marcos.usecase;

import br.marcos.core.domain.Transaction;

public interface TransferUserCase {
    Boolean transfer(Transaction transaction);
}
