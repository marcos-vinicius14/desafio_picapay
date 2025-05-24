package br.com.marcos.usecase;

import br.marcos.core.domain.Wallet;

import java.math.BigDecimal;

public interface UserConsultBalanceCase {
    BigDecimal consultBalance(Wallet wallet);
}
