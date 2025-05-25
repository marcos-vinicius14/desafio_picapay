package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.TransferGateway;
import br.com.marcos.usecase.CreateTransactionCase;
import br.com.marcos.usecase.FindWalletByTaxNumberCase;
import br.com.marcos.usecase.TransactionValidateCase;
import br.com.marcos.usecase.TransferCase;
import br.marcos.core.domain.Transaction;
import br.marcos.core.domain.Wallet;
import br.marcos.core.domain.exceptions.InternalServerErrorExcetion;
import br.marcos.core.domain.exceptions.TransferException;
import br.marcos.core.domain.exceptions.enums.ErroCodeEnum;

import java.math.BigDecimal;

public class TransferCaseImpl implements TransferCase {
    private final FindWalletByTaxNumberCase findUserByTaxNumberCase;
    private final TransactionValidateCase transactionValidateCase;
    private final CreateTransactionCase createTransactionCase;
    private final TransferGateway transferGateway;

    public TransferCaseImpl(FindWalletByTaxNumberCase findUserByTaxNumberCase, TransactionValidateCase transactionValidateCase, Transaction transaction, CreateTransactionCase createTransactionCase, TransferGateway transferGateway) {
        this.findUserByTaxNumberCase = findUserByTaxNumberCase;
        this.transactionValidateCase = transactionValidateCase;
        this.createTransactionCase = createTransactionCase;
        this.transferGateway = transferGateway;
    }

    @Override
    public Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value) throws InternalServerErrorExcetion, TransferException {
        Wallet from = findUserByTaxNumberCase.findUserByTaxNumber(fromTaxNumber);
        Wallet to = findUserByTaxNumberCase.findUserByTaxNumber(toTaxNumber);

        from.transfer(value);
        to.receiveTransfer(value);

        Transaction transaction = createTransactionCase.create(new Transaction(to, from, value));
        transactionValidateCase.validate(transaction);

        if (!transferGateway.transfer(transaction)) {
            throw new InternalServerErrorExcetion(ErroCodeEnum.TR0003.getMessage(), ErroCodeEnum.TR0003.getCode());
        }

        return  true;

    }
}
