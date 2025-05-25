package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.TransactionPinValidateGateway;
import br.com.marcos.usecase.TransactionPinValidateCase;
import br.com.marcos.usecase.UpdateTransactionPinCase;
import br.marcos.core.domain.TransactionPin;
import br.marcos.core.domain.exceptions.PinException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

public class TransactionPinValidateCaseImpl implements TransactionPinValidateCase {
    private final TransactionPinValidateGateway transactionPinValidateGateway;
    private final UpdateTransactionPinCase updateTransactionPinCase;

    public TransactionPinValidateCaseImpl(TransactionPinValidateGateway transactionPinValidateGateway, UpdateTransactionPinCase updateTransactionPinCase) {
        this.transactionPinValidateGateway = transactionPinValidateGateway;
        this.updateTransactionPinCase = updateTransactionPinCase;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws PinException {
        if (transactionPin.getBlocked()) {
            throw new PinException(ErroCodeEnum.PIN0001.getMessage(), ErroCodeEnum.PIN0001.getCode());
        }
        if (!transactionPinValidateGateway.validate(transactionPin)) {
            transactionPin.setAttempt();
            updateTransactionPinCase.update(transactionPin);
            throw new PinException(ErroCodeEnum.pin0001GetMessage(transactionPin.getAttempt()), ErroCodeEnum.PIN0002.getCode());
        }

        if(transactionPin.getAttempt() < 3) {
            transactionPin.restaureAttempt();
            updateTransactionPinCase.update(transactionPin);
        }

        return true;

    }
}
