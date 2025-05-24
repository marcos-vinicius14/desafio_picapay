package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.CreateUserGateway;
import br.com.marcos.usecase.*;
import br.marcos.core.domain.TransactionPin;
import br.marcos.core.domain.User;
import br.marcos.core.domain.Wallet;
import br.marcos.core.domain.exceptions.BadRequestException;
import br.marcos.core.domain.exceptions.TaxNumberException;
import br.marcos.core.domain.exceptions.TransactionPinException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

import java.math.BigDecimal;

public class CreateUserCaseImpl implements CreateUserCase {
    private final TaxNumberAvaliableCase taxNumberAvaliableCase;
    private final EmailAvaliableCase emailAvaliableCase;
    private final CreateUserGateway createUserGateway;
    private final CreateWalletCase createWalletCase;
    private final CreateTransactionPinCase createTransactionPinCase;

    public CreateUserCaseImpl(TaxNumberAvaliableCase taxNumberAvaliableCase, EmailAvaliableCase emailAvaliableCase, CreateUserGateway createUserGateway, CreateWalletCase createWalletCase, CreateTransactionPinCase createTransactionPinCase) {
        this.taxNumberAvaliableCase = taxNumberAvaliableCase;
        this.emailAvaliableCase = emailAvaliableCase;
        this.createUserGateway = createUserGateway;
        this.createWalletCase = createWalletCase;
        this.createTransactionPinCase = createTransactionPinCase;
    }

    @Override
    public void create(User user, String pin) throws TaxNumberException, BadRequestException, TransactionPinException {
        if (!taxNumberAvaliableCase.isTaxNumberAvaliable(user.getTaxNumber().getValue())) {
            throw new TaxNumberException(ErroCodeEnum.ON002.getMessage(), ErroCodeEnum.ON002.getCode());
        }

        if(!emailAvaliableCase.isEmailValid(user.getEmail())) {
            throw new BadRequestException(ErroCodeEnum.ON003.getMessage(), ErroCodeEnum.ON003.getCode());
        }

        User userSaved = createUserGateway.create(user);

        createWalletCase.craete(new Wallet(userSaved, BigDecimal.ZERO));
        createTransactionPinCase.create(new TransactionPin(userSaved, pin));
    }
}
