package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.CreateUserGateway;
import br.marcos.core.domain.User;
import br.marcos.core.domain.Wallet;
import br.marcos.infraescruture.entities.TransactionPinEntity;
import br.marcos.infraescruture.entities.UserEntity;
import br.marcos.infraescruture.mappers.TransactionPinMapper;
import br.marcos.infraescruture.mappers.UserMapper;
import br.marcos.infraescruture.mappers.WalletMapper;
import br.marcos.infraescruture.repositories.TransactionPinEntityRepository;
import br.marcos.infraescruture.repositories.UserEntityRepository;
import br.marcos.infraescruture.repositories.WalletEntityRepository;
import static br.marcos.infraescruture.utils.Utilities.log;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class CraeteUserGatewayImpl implements CreateUserGateway {
    private final UserEntityRepository userEntityRepository;
    private final TransactionPinEntityRepository transactionPinEntityRepository;
    private final WalletEntityRepository walletEntityRepository;
    private final UserMapper userMapper;
    private final TransactionPinMapper transactionPinMapper;
    private final WalletMapper walletMapper;

    public CraeteUserGatewayImpl(UserEntityRepository userEntityRepository, TransactionPinEntityRepository transactionPinEntityRepository, WalletEntityRepository walletEntityRepository, UserMapper userMapper, TransactionPinMapper transactionPinMapper, WalletMapper walletMapper) {
        this.userEntityRepository = userEntityRepository;
        this.transactionPinEntityRepository = transactionPinEntityRepository;
        this.walletEntityRepository = walletEntityRepository;
        this.userMapper = userMapper;
        this.transactionPinMapper = transactionPinMapper;
        this.walletMapper = walletMapper;
    }

    @Override
    @Transactional
    public Boolean create(User user, Wallet wallet) {
        try {
            log.info(String.format("Initiliaze creation user: %s::CreateUserGatewayImpl", user));
            UserEntity userSaved = userEntityRepository.save(userMapper.toUserEntity(user));
            TransactionPinEntity transactionPinSaved = transactionPinEntityRepository.save(transactionPinMapper.toTransactionPinEntity(wallet.getTransactionPin()));
            walletEntityRepository.save(walletMapper.toWallletEntity(wallet, userSaved, transactionPinSaved));

            log.info(String.format("User: %s created sucess::CreateUserGatewayImpl", user));
            return true;
        } catch (Exception e) {
            log.error(String.format("Error creating user: %s::CreateUserGatewayImpl", user), e);
            return false;
        }
    }
}
