package br.marcos.infraescruture.dto.response;


public record BaseResponse<T>(
        Boolean success,
        String message,
        T result,
        ErrorResponse error
) {

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {
        private Boolean successField;
        private String messageField;
        private T resultField;
        private ErrorResponse errorField;

        private Builder() {
        }


        public Builder<T> success(Boolean success) {
            this.successField = success;
            return this;
        }

        public Builder<T> message(String message) {
            this.messageField = message;
            return this;
        }

        public Builder<T> result(T result) {
            this.resultField = result;
            return this;
        }

        public Builder<T> error(ErrorResponse error) {
            this.errorField = error;
            return this;
        }

        public BaseResponse<T> build() {
            return new BaseResponse<>(this.successField, this.messageField, this.resultField, this.errorField);
        }
    }
}