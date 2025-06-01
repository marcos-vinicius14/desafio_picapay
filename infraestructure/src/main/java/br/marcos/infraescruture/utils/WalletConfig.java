package br.marcos.infraescruture.utils;

import br.com.marcos.application.gateway.*;
import br.com.marcos.application.usecaseimpl.*;
import br.com.marcos.usecase.*;
import br.marcos.core.domain.Transaction;
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

    @Bean
    public TransactionValidateCase transactionValidateCase(TransactionPinValidateGateway transactionPinValidateGateway) {
        return new TransactionValidateCaseImpl(transactionPinValidateGateway);
    }

    @Bean
    public CreateTransactionCase createTransactionCase(CreateTransactionGateway createTransactionGateway) {
        return new CreateTransactionCaseImpl(createTransactionGateway);
    }

    @Bean
    public UserNotificationCase userNotificationCase(UserNotificationGateway userNotificationGateway) {
        return new UserNotificationCaseImpl(userNotificationGateway);
    }



    @Bean
    public TransferCase transferCase(FindWalletByTaxNumberCase findUserByTaxNumberCase, TransactionValidateCase transactionValidateCase, Transaction transaction, CreateTransactionCase createTransactionCase, TransferGateway transferGateway, UserNotificationCase userNotificationCase, TransactionPinValidateCase transactionPinValidateCase) {
        return new TransferCaseImpl(
                findUserByTaxNumberCase,
                transactionValidateCase,
                transaction,
                createTransactionCase,
                transferGateway,
                userNotificationCase,
                transactionPinValidateCase
        );
    }


}
