package br.com.marcos.application.gateway;

import br.marcos.core.domain.Wallet;

public interface FindWalletByTaxNumberGateway {
    Wallet findWalletByTaxNumber(String taxNumber);
}
