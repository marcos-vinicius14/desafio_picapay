package br.com.marcos.usecase;

import br.marcos.core.domain.Transaction;

public interface CreateTransactionCase {
    void create (Transaction transaction);
}
