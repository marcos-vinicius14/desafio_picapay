package br.com.marcos.usecase;


import br.marcos.core.domain.exceptions.NotFoundException;

import java.math.BigDecimal;

public interface UserConsultBalanceCase {
    BigDecimal consultBalance(String taxNumber) throws NotFoundException;
}
