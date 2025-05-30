package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.FindWalletByTaxNumberGateway;
import br.marcos.core.domain.Wallet;
import br.marcos.infraescruture.mappers.WalletMapper;
import br.marcos.infraescruture.repositories.WalletEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway {
    private final WalletEntityRepository walletEntityRepository;
    private final WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository, WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findWalletByTaxNumber(String taxNumber) throws Exception {
        return walletMapper.toWallet(walletEntityRepository.findByUserTaxNumber(taxNumber));
    }
}
