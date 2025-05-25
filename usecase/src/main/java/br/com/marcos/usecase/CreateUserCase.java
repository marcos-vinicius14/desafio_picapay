package br.com.marcos.usecase;

import br.marcos.core.domain.User;
import br.marcos.core.domain.exceptions.BadRequestException;
import br.marcos.core.domain.exceptions.InternalServerErrorExcetion;
import br.marcos.core.domain.exceptions.TaxNumberException;
import br.marcos.core.domain.exceptions.TransactionPinException;

public interface CreateUserCase {
    void create(User user, String pin) throws TaxNumberException, BadRequestException, TransactionPinException, InternalServerErrorExcetion;
}
