package br.marcos.infraescruture.mappers;

import br.marcos.core.domain.Wallet;
import br.marcos.infraescruture.entities.TransactionPinEntity;
import br.marcos.infraescruture.entities.UserEntity;
import br.marcos.infraescruture.entities.WallletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    private final TransactionPinMapper transactionPinMapper;
    private final UserMapper userMapper;

    public WalletMapper(TransactionPinMapper transactionPinMapper, UserMapper userMapper) {
        this.transactionPinMapper = transactionPinMapper;
        this.userMapper = userMapper;
    }

    public WallletEntity toWallletEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPin) {
        return new WallletEntity(
                wallet.getBalance(),
                user,
                transactionPin,
                wallet.getUpdatedAt(),
                wallet.getCreatedAt()
        );
    }

    public WallletEntity toWallletEntity(Wallet wallet) {
        return new WallletEntity(
                wallet.getBalance(),
                userMapper.toUserEntity(wallet.getUser()),
                transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()),
                wallet.getUpdatedAt(),
                wallet.getCreatedAt()
        );
    }

    public Wallet toWallet(WallletEntity wallletEntity) throws Exception {
        if (wallletEntity == null) {
            return null;
        }

        return new Wallet(
                wallletEntity.getId(),
                transactionPinMapper.toTransactionPin(wallletEntity.getTransactionPinEntity()),
                wallletEntity.getBalance(),
                userMapper.toUser(wallletEntity.getUser()),
                wallletEntity.getCreatedAt(),
                wallletEntity.getUpdatedAt()

        );
    }
}
