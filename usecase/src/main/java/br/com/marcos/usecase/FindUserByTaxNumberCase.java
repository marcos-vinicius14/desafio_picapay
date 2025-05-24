package br.com.marcos.usecase;

import br.marcos.core.domain.User;

public interface FindUserByTaxNumberCase {
    User findUserByTaxNumber(String taxNumber);
}
