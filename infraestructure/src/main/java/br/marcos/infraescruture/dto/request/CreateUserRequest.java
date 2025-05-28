package br.marcos.infraescruture.dto.request;

import br.marcos.core.domain.TransactionPin;
import br.marcos.core.domain.enums.UserType;

public record CreateUserRequest(
        String email,
        String password,
        String taxNumber,
        String fullname,
        UserType type,
        TransactionPin transactionPin
) {
}
