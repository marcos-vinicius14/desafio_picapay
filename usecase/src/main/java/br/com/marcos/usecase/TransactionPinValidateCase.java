package br.com.marcos.usecase;

import br.marcos.core.domain.TransactionPin;
import br.marcos.core.domain.exceptions.PinException;
import br.marcos.core.domain.exceptions.TransferException;

public interface TransactionPinValidateCase {
    Boolean validate(TransactionPin transactionPin) throws TransferException, PinException;
}
