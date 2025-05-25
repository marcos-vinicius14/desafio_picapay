package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.FindWalletByTaxNumberGateway;
import br.com.marcos.usecase.FindWalletByTaxNumberCase;
import br.marcos.core.domain.Wallet;
import br.marcos.core.domain.exceptions.NotFoundException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

public class FindWalletByTaxNumberCaseImpl implements FindWalletByTaxNumberCase {
    private final FindWalletByTaxNumberGateway findWalletByTaxNumberGateway;

    public FindWalletByTaxNumberCaseImpl(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        this.findWalletByTaxNumberGateway = findWalletByTaxNumberGateway;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws NotFoundException {
        Wallet walletByTaxNumber = findWalletByTaxNumberGateway.findWalletByTaxNumber(taxNumber);
        if (walletByTaxNumber == null) {
            throw new NotFoundException(ErroCodeEnum.WA0001.getMessage(), ErroCodeEnum.WA0001.getCode());
        }

        return walletByTaxNumber;
    }
}
