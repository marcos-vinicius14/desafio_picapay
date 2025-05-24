package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.CreateTransactionPinCaseGateway;
import br.com.marcos.usecase.CreateTransactionPinCase;
import br.marcos.core.domain.TransactionPin;

public class CreateTransactionPinCaseImpl implements CreateTransactionPinCase {
    private final CreateTransactionPinCaseGateway createTransactionPinGateway;

    public CreateTransactionPinCaseImpl(CreateTransactionPinCaseGateway createTransactionPinGateway) {
        this.createTransactionPinGateway = createTransactionPinGateway;
    }

    @Override
    public void create(TransactionPin transactionPin) {
        createTransactionPinGateway.create(transactionPin);
    }
}
