package br.marcos.infraescruture.services;

import br.com.marcos.application.gateway.EmailAvalibleGateway;
import br.marcos.infraescruture.repositories.UserEntityRepository;
import org.springframework.stereotype.Service;

import static br.marcos.infraescruture.utils.Utilities.log;

@Service
public class EmailAvaliableGatewayImpl implements EmailAvalibleGateway {
    private final UserEntityRepository userEntityRepository;

    public EmailAvaliableGatewayImpl(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Boolean isEmailValid(String email) {
        log.info("Checking if email is valid::EmailAvaliableGatewayImpl");
        return !userEntityRepository.existsByEmail(email);
    }
}
