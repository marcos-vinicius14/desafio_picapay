package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.CreateUserGateway;
import br.com.marcos.usecase.*;
import br.marcos.core.domain.TransactionPin;
import br.marcos.core.domain.User;
import br.marcos.core.domain.Wallet;
import br.marcos.core.domain.exceptions.BadRequestException;
import br.marcos.core.domain.exceptions.InternalServerErrorExcetion;
import br.marcos.core.domain.exceptions.TaxNumberException;
import br.marcos.core.domain.exceptions.TransactionPinException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

import java.math.BigDecimal;

public class CreateUserCaseImpl implements CreateUserCase {
    private final TaxNumberAvaliableCase taxNumberAvaliableCase;
    private final EmailAvaliableCase emailAvaliableCase;
    private final CreateUserGateway createUserGateway;

    public CreateUserCaseImpl(TaxNumberAvaliableCase taxNumberAvaliableCase, EmailAvaliableCase emailAvaliableCase, CreateUserGateway createUserGateway) {
        this.taxNumberAvaliableCase = taxNumberAvaliableCase;
        this.emailAvaliableCase = emailAvaliableCase;
        this.createUserGateway = createUserGateway;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, BadRequestException, TransactionPinException, InternalServerErrorExcetion {
        if (!taxNumberAvaliableCase.isTaxNumberAvaliable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErroCodeEnum.ON002.getMessage(), ErroCodeEnum.ON002.getCode());
        }

        if(!emailAvaliableCase.isEmailValid(user.getEmail())) {
            throw new BadRequestException(ErroCodeEnum.ON003.getMessage(), ErroCodeEnum.ON003.getCode());
        }

        if (!createUserGateway.create(user, new Wallet(user, BigDecimal.ZERO), new TransactionPin(user, pin))) {
            throw new InternalServerErrorExcetion(ErroCodeEnum.ON004.getMessage(), ErroCodeEnum.ON004.getCode());
        };

    }
}
