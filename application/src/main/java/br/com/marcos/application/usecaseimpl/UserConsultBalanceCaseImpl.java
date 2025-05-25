package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.UserConsultBalanceGateway;
import br.com.marcos.usecase.UserConsultBalanceCase;
import br.marcos.core.domain.Wallet;

import java.math.BigDecimal;

public class UserConsultBalanceCaseImpl implements UserConsultBalanceCase {
    private final UserConsultBalanceGateway userConsultBalanceGateway;

    public UserConsultBalanceCaseImpl(UserConsultBalanceGateway userConsultBalanceGateway) {
        this.userConsultBalanceGateway = userConsultBalanceGateway;
    }

    @Override
    public BigDecimal consultBalance(Wallet wallet) {
        return userConsultBalanceGateway.consultBalance(wallet);
    }
}
