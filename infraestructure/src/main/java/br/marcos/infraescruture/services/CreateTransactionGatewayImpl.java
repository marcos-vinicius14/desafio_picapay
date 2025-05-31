package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.CreateTransactionGateway;
import br.marcos.core.domain.Transaction;
import br.marcos.infraescruture.entities.TransactionEntity;
import br.marcos.infraescruture.mappers.TransactionMapper;
import br.marcos.infraescruture.repositories.TransactionEntityRepository;
import org.springframework.stereotype.Service;
import static br.marcos.infraescruture.utils.Utilities.log;

@Service
public class CreateTransactionGatewayImpl implements CreateTransactionGateway {
    private final TransactionEntityRepository transactionEntityRepository;
    private final TransactionMapper transactionMapper;

    public CreateTransactionGatewayImpl(TransactionEntityRepository transactionEntityRepository, TransactionMapper transactionMapper) {
        this.transactionEntityRepository = transactionEntityRepository;
        this.transactionMapper = transactionMapper;
    }

    @Override
    public Transaction create(Transaction transaction) {
        try {
            TransactionEntity transactionEntity = transactionMapper.createTransaction(transaction);
            log.info("Transação salva com sucesso. ID da entidade: {}", transactionEntity.getId());
            return transactionMapper.toTransaction(transactionEntityRepository.save(transactionEntity));
        } catch (Exception e) {
            log.error("<<<<<<< ERROR IN CREATE TRANSACTION:: CreateTransactionGatewayImpl: {}" , e.getMessage());
            return null;
        }
    }
}
