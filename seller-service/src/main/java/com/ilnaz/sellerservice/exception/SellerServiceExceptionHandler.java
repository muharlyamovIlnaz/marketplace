package com.ilnaz.sellerservice.exception;


import com.ilnaz.sellerservice.dto.SellerServiceResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SellerServiceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<SellerServiceResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        SellerServiceResponse response = SellerServiceResponse.builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
