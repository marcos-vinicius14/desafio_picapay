package br.marcos.infraescruture.services;
import static br.marcos.infraescruture.utils.Utilities.log;

import br.com.marcos.application.gateway.TaxNumberAvalibleGateway;
import br.marcos.infraescruture.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class TaxNumberAvaliableGatewayImpl implements TaxNumberAvalibleGateway {
    private final UserEntityRepository userEntityRepository;

    public TaxNumberAvaliableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean isValidTaxNumber(String taxNumber) {
        log.info("Initialize verification if tax number is valid::TaxNumberAvaliableGatewayImpl");
        return !userEntityRepository.existsByTaxNumber(taxNumber);
    }
}
