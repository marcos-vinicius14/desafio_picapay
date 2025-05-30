package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.TransactionPinValidateGateway;
import br.marcos.core.domain.TransactionPin;
import br.marcos.infraescruture.entities.TransactionPinEntity;
import br.marcos.infraescruture.repositories.TransactionPinEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class TransactionPinValidateGatewayImpl implements TransactionPinValidateGateway {
    private final TransactionPinEntityRepository transactionPinEntityRepository;

    public TransactionPinValidateGatewayImpl(TransactionPinEntityRepository transactionPinEntityRepository) {
        this.transactionPinEntityRepository = transactionPinEntityRepository;
    }


    @Override
    public Boolean validate(TransactionPin transactionPin) {
        Optional<TransactionPinEntity> transactionSaved = transactionPinEntityRepository.findById(transactionPin.getPinId());
        return transactionSaved.filter(transactionPinEntity -> Objects.equals(transactionPinEntity.getPin(), transactionPin.getPin())).isPresent();
    }
}
