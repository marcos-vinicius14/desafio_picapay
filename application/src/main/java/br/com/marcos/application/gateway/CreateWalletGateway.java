package br.com.marcos.application.gateway;

import br.marcos.core.domain.Wallet;

public interface CreateWalletGateway {
    void create(Wallet wallet);
}
