package br.marcos.infraescruture.mappers;

import br.marcos.core.domain.Transaction;
import br.marcos.core.domain.enums.TransactionStatusEnum;
import br.marcos.infraescruture.entities.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    private final WalletMapper walletMapper;

    public TransactionMapper(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public TransactionEntity toTransactionEntity(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWallletEntity(transaction.getFromWallet()),
                walletMapper.toWallletEntity(transaction.getToWallet()),
                transaction.getValue(),
                transaction.getStatus(),
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity createTransaction(Transaction transaction) {
        return new TransactionEntity(
                walletMapper.toWallletEntity(transaction.getFromWallet()),
                walletMapper.toWallletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CREATED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public Transaction toTransaction(TransactionEntity transactionEntity) throws Exception {
        return new Transaction(
                transactionEntity.getId(),
                walletMapper.toWallet(transactionEntity.getFromWallet()),
                walletMapper.toWallet(transactionEntity.getToWallet()),
                transactionEntity.getTransactionValue(),
                transactionEntity.getStatus(),
                transactionEntity.getCreatedAt(),
                transactionEntity.getUpdatedAt()
        );
    }

    public TransactionEntity toConcludeTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWallletEntity(transaction.getFromWallet()),
                walletMapper.toWallletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.SUCCESS,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }

    public TransactionEntity toCancelTransaction(Transaction transaction) {
        return new TransactionEntity(
                transaction.getId(),
                walletMapper.toWallletEntity(transaction.getFromWallet()),
                walletMapper.toWallletEntity(transaction.getToWallet()),
                transaction.getValue(),
                TransactionStatusEnum.CANCELLED,
                transaction.getCreatedAt(),
                transaction.getUpdatedAt()
        );
    }
}
