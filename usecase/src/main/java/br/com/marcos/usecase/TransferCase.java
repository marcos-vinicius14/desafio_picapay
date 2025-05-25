package br.com.marcos.usecase;

import br.marcos.core.domain.exceptions.InternalServerErrorExcetion;
import br.marcos.core.domain.exceptions.NotFoundException;
import br.marcos.core.domain.exceptions.NotificationException;
import br.marcos.core.domain.exceptions.TransferException;

import java.math.BigDecimal;

public interface TransferCase {
    Boolean transfer(String toTaxNumber, String fromTaxNumber, BigDecimal value, String pin) throws InternalServerErrorExcetion, TransferException, NotFoundException, NotificationException;
}
