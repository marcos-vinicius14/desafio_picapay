package br.com.marcos.application.usecaseimpl;

import br.com.marcos.application.gateway.TaxNumberAvalibleGateway;
import br.com.marcos.usecase.TaxNumberAvaliableCase;

public class TaxNumberAvalibleCaseImpl implements TaxNumberAvaliableCase {
    private final TaxNumberAvalibleGateway taxNumberAvalibleGateway;

    public TaxNumberAvalibleCaseImpl(TaxNumberAvalibleGateway taxNumberAvalibleGateway) {
        this.taxNumberAvalibleGateway = taxNumberAvalibleGateway;
    }

    @Override
    public Boolean isTaxNumberAvaliable(String taxNumber) {
        return taxNumberAvalibleGateway.isValidTaxNumber(taxNumber);
    }
}
