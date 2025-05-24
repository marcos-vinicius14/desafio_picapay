package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.CreateWalletGateway;
import br.com.marcos.usecase.CreateWalletCase;
import br.marcos.core.domain.Wallet;

public class CreateWalletCaseImpl implements CreateWalletCase {
    private final CreateWalletGateway createWalletGateway;

    public CreateWalletCaseImpl(CreateWalletGateway createWalletGateway) {
        this.createWalletGateway = createWalletGateway;
    }

    @Override
    public void craete(Wallet wallet) {
        createWalletGateway.create(wallet);
    }
}
