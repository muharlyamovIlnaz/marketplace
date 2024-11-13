package com.ilnaz.gateway.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class SellerServiceResponse<T> {
    private int status;
    private String message;
    private T body;


    public static <T> SellerServiceResponse<T> ok(String message, T body) {
        return SellerServiceResponse.<T>builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .body(body)
                .build();
    }

    public static SellerServiceResponse<Void> ok(String message) {
        return SellerServiceResponse.<Void>builder()
                .status(HttpStatus.OK.value())
                .message(message)
                .build();
    }

    public static <T> SellerServiceResponse<T> notFoundError(String message, T body) {
        return SellerServiceResponse.<T>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(message)
                .body(body)
                .build();
    }

    public static SellerServiceResponse<Void> notFoundError(String message) {
        return SellerServiceResponse.<Void>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(message)
                .build();
    }
}
