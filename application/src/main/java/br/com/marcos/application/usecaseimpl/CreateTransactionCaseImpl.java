package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.CreateTransactionGateway;
import br.com.marcos.usecase.CreateTransactionCase;
import br.marcos.core.domain.Transaction;
import br.marcos.core.domain.exceptions.TransferException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

public class CreateTransactionCaseImpl implements CreateTransactionCase {
    private final CreateTransactionGateway createTransactionGateway;

    public CreateTransactionCaseImpl(CreateTransactionGateway createTransactionGateway) {
        this.createTransactionGateway = createTransactionGateway;
    }

    @Override
    public Transaction create(Transaction transaction) throws TransferException {
        Transaction transactionSaved = createTransactionGateway.create(transaction);

        if(transactionSaved == null) {
            throw new TransferException(ErroCodeEnum.ATH0001.getMessage(), ErroCodeEnum.ATH0001.getCode());
        }

        return transactionSaved;
    }
}
