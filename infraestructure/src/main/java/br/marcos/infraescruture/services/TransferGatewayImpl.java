package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.TransferGateway;
import br.marcos.core.domain.Transaction;
import br.marcos.infraescruture.mappers.TransactionMapper;
import br.marcos.infraescruture.mappers.WalletMapper;
import br.marcos.infraescruture.repositories.TransactionEntityRepository;
import br.marcos.infraescruture.repositories.WalletEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import static br.marcos.infraescruture.utils.Utilities.log;

@Service
public class TransferGatewayImpl implements TransferGateway {
    private final WalletEntityRepository walletEntityRepository;
    private final TransactionEntityRepository transactionEntityRepository;
    private final WalletMapper walletMapper;
    private final TransactionMapper transactionMapper;

    public TransferGatewayImpl(WalletEntityRepository walletEntityRepository, TransactionEntityRepository transactionEntityRepository, WalletMapper walletMapper, TransactionMapper transactionMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.transactionEntityRepository = transactionEntityRepository;
        this.walletMapper = walletMapper;
        this.transactionMapper = transactionMapper;
    }

    @Transactional
    @Override
    public Boolean transfer(Transaction transaction) {
         try {
             log.info("Transfer transaction started::{}", TransferGatewayImpl.class.getName());
             walletEntityRepository.save(walletMapper.toWallletEntity(transaction.getFromWallet()));
             walletEntityRepository.save(walletMapper.toWallletEntity(transaction.getToWallet()));
             transactionEntityRepository.save(transactionMapper.toConcludeTransaction(transaction));
             log.info("Transfer transaction finished with sucess::{}", TransferGatewayImpl.class.getName());
             return true;
         } catch (Exception e) {
             transactionEntityRepository.save(transactionMapper.toCancelTransaction(transaction));
             log.error("<<<<<<<< Transfer transaction failed::{} >>>>>>>>>", TransferGatewayImpl.class.getName());
             log.error("<<<<<<< ERROR {} >>>>>>>>>", e.getMessage());
             log.error("<<<<<<<< Details of Error: {} >>>>>>>",
                     e.getStackTrace().toString());
             return false;
         }
    }
}
