package br.com.marcos.usecase;

import br.marcos.core.domain.Wallet;

public interface FindWalletByTaxNumberCase {
    Wallet findUserByTaxNumber(String taxNumber);
}
