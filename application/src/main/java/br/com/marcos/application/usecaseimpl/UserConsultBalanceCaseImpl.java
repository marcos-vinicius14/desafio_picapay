package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.UserConsultBalanceGateway;
import br.com.marcos.usecase.FindWalletByTaxNumberCase;
import br.com.marcos.usecase.UserConsultBalanceCase;
import br.marcos.core.domain.exceptions.NotFoundException;

import java.math.BigDecimal;

public class UserConsultBalanceCaseImpl implements UserConsultBalanceCase {
    private final UserConsultBalanceGateway userConsultBalanceGateway;
    private final FindWalletByTaxNumberCase findWalletByTaxNumberCase;

    public UserConsultBalanceCaseImpl(FindWalletByTaxNumberCase findWalletByTaxNumberCase) {
        this.userConsultBalanceGateway = userConsultBalanceGateway;
        this.findWalletByTaxNumberCase = findWalletByTaxNumberCase;
    }

    @Override
    public BigDecimal consultBalance(String taxNumber) throws NotFoundException {
        return findWalletByTaxNumberCase.findWalletByTaxNumber(taxNumber).getBalance();
    }
}
