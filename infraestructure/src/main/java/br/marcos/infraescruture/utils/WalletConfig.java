package br.marcos.infraescruture.utils;

import br.com.marcos.application.gateway.FindWalletByTaxNumberGateway;
import br.com.marcos.application.usecaseimpl.FindWalletByTaxNumberCaseImpl;
import br.com.marcos.application.usecaseimpl.UserConsultBalanceCaseImpl;
import br.com.marcos.usecase.FindWalletByTaxNumberCase;
import br.com.marcos.usecase.UserConsultBalanceCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    @Bean
    public FindWalletByTaxNumberCase findWalletByTaxNumber(FindWalletByTaxNumberGateway findWalletByTaxNumberGateway) {
        return new FindWalletByTaxNumberCaseImpl(findWalletByTaxNumberGateway);
    }

    @Bean
    public UserConsultBalanceCase userConsultBalanceCase(FindWalletByTaxNumberCase findWalletByTaxNumberCase) {
        return new UserConsultBalanceCaseImpl(findWalletByTaxNumberCase);
    }
}
