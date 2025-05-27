package br.com.marcos.usecase;

import br.marcos.core.domain.exceptions.*;

import java.math.BigDecimal;

public interface TransferCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) throws InternalServerErrorExcetion, TransferException, NotFoundException, NotificationException, PinException;
}
