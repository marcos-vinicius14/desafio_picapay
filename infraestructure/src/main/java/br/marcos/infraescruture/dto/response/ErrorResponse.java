package br.marcos.infraescruture.dto.response;

import java.util.List;

public record ErrorResponse(
        String code,
        String message,
        List<ValiditionError> validitionErrorList
) {
}
