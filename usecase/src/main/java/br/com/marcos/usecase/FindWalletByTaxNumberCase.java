package br.com.marcos.usecase;

import br.marcos.core.domain.Wallet;
import br.marcos.core.domain.exceptions.NotFoundException;

public interface FindWalletByTaxNumberCase {
    Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException;
}
