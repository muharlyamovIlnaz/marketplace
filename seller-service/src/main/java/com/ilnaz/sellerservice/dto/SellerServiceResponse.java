package com.ilnaz.sellerservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SellerServiceResponse {
    private int status;
    private String message;
    private Object body;
}
