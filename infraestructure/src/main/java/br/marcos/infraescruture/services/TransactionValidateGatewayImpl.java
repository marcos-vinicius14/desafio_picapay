package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.TransactionPinValidateGateway;
import br.marcos.client.dto.ApiValidateResponse;
import br.marcos.client.service.ApiValidateService;
import br.marcos.core.domain.TransactionPin;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TransactionValidateGatewayImpl implements TransactionPinValidateGateway {
    private final ApiValidateService apiValidateService;

    public TransactionValidateGatewayImpl(ApiValidateService apiValidateService) {
        this.apiValidateService = apiValidateService;
    }

    @Override
    public Boolean validate(TransactionPin transactionPin) throws IOException, InterruptedException {
            ApiValidateResponse response = apiValidateService.validate();

            if (response == null) {
                return false;
            }

            return response.sucess();
    }
}
