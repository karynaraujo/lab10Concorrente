package com.ecommerce.concorrente.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SaleService {

    private final ConcurrentHashMap<String, AtomicInteger> salesReport = new ConcurrentHashMap<>();

    public void registerSale(String productId, int quantity) {
        salesReport.compute(productId, (id, prev) -> {
            if (prev == null) return new AtomicInteger(quantity);
            prev.addAndGet(quantity);
            return prev;
        });

        System.out.println("Mock: Registrando venda de " + quantity + " unidade(s) do produto " + productId);
    }

    public ConcurrentHashMap<String, AtomicInteger> getSalesReport() {
        return salesReport;
    }
}
