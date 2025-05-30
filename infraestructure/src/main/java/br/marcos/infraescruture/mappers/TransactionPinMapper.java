package br.marcos.infraescruture.mappers;

import br.marcos.core.domain.TransactionPin;
import br.marcos.infraescruture.entities.TransactionPinEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionPinMapper {
    public TransactionPinEntity toTransactionPinEntity(TransactionPin transaction) {
        return new TransactionPinEntity(
                transaction.getPin(),
                transaction.getAttempt(),
                transaction.getBlocked(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionPin toTransactionPin(TransactionPinEntity transactionPinEntity) {
        return new TransactionPin(
                transactionPinEntity.getId(),
                transactionPinEntity.getPin(),
                transactionPinEntity.getAttempt(),
                transactionPinEntity.getBlocked(),
                transactionPinEntity.getUpdatedAt()
        );
    }
}
