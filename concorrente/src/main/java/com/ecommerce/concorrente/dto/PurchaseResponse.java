package com.ecommerce.concorrente.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PurchaseResponse {
    private String message;
    private String productId;
    private String productName;
    private int remainingStock;
}
