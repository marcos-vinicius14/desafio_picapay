package br.marcos.infraescruture.mappers;

import br.marcos.core.domain.Wallet;
import br.marcos.infraescruture.entities.TransactionPinEntity;
import br.marcos.infraescruture.entities.UserEntity;
import br.marcos.infraescruture.entities.WallletEntity;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {
    public WallletEntity toWallletEntity(Wallet wallet, UserEntity user, TransactionPinEntity transactionPin) {
        return new WallletEntity(
                wallet.getBalance(),
                user,
                transactionPin,
                wallet.getUpdatedAt(),
                wallet.getCreatedAt()
        );
    }
}
