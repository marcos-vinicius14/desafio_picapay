package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.TransactionValidateGateway;
import br.com.marcos.usecase.TransactionValidateCase;
import br.marcos.core.domain.Transaction;
import br.marcos.core.domain.exceptions.TransferException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

public class TransactionValidateCaseImpl implements TransactionValidateCase {
    private final TransactionValidateGateway transactionValidateGateway;

    public TransactionValidateCaseImpl(TransactionValidateGateway transactionValidateGateway) {
        this.transactionValidateGateway = transactionValidateGateway;
    }

    @Override
    public Boolean validate(Transaction transaction) throws TransferException {
        if (!transactionValidateGateway.validate(transaction)) {
            throw new TransferException(ErroCodeEnum.TR0004.getMessage(), ErroCodeEnum.TR0004.getCode());
        }

        return true;
    }
}
