package com.ecommerce.concorrente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.concorrente.dto.PurchaseRequest;
import com.ecommerce.concorrente.dto.PurchaseResponse;
import com.ecommerce.concorrente.service.ProductService;

@RestController
@RequestMapping
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<PurchaseResponse> purchase(@RequestBody PurchaseRequest request) {
        PurchaseResponse response = productService.purchaseProduct(request);
        return ResponseEntity.ok(response);
    }
}
