package br.com.marcos.application.gateway;


import br.marcos.core.domain.Wallet;

import java.math.BigDecimal;

public interface UserConsultBalanceGateway {
    BigDecimal consultBalance(Wallet wallet);
}
