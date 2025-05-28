package br.marcos.infraescruture.dto.response;

public record ValiditionError(
        String field,
        String message
) {
}
