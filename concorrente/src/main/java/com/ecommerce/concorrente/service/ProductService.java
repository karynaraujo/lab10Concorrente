package com.ecommerce.concorrente.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.concorrente.dto.PurchaseRequest;
import com.ecommerce.concorrente.dto.PurchaseResponse;
import com.ecommerce.concorrente.exceptions.BadRequestException;
import com.ecommerce.concorrente.exceptions.NotFoundException;
import com.ecommerce.concorrente.models.Product;
import com.ecommerce.concorrente.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SaleService saleService;

    private final ConcurrentHashMap<String, Product> mockProductStore = new ConcurrentHashMap<>();

    @Autowired
    public ProductService(ProductRepository productRepository, SaleService saleService) {
        this.productRepository = productRepository;
        this.saleService = saleService;

        mockProductStore.put("1234", new Product("1234", "Smartphone", 999.90, 20));
        mockProductStore.put("5678", new Product("5678", "Fone de Ouvido", 199.90, 50));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public PurchaseResponse purchaseProduct(PurchaseRequest request) {
        Product product = mockProductStore.get(request.getId());
    
        if (product == null) {
            System.out.println("[ERRO] Produto com ID " + request.getId() + " não encontrado.");
            throw new NotFoundException("Produto não encontrado, sinto muito!");
        }
    
        boolean success = product.decreaseStock(request.getQuantity());
    
        if (!success) {
            System.out.println("[ERRO] Estoque insuficiente para o produto " + product.getName() +
                    ". Quantidade solicitada: " + request.getQuantity() +
                    ", disponível: " + product.getQuantity());
            throw new BadRequestException("Estoque insuficiente. Disponível: " + product.getQuantity());
        }
    
        saleService.mockRegisterSale(product.getId(), request.getQuantity());
    
        System.out.println("[INFO] Compra realizada com sucesso. Produto: " + product.getName() +
                ", Quantidade: " + request.getQuantity() +
                ", Restante: " + product.getQuantity());
    
        return new PurchaseResponse(
                "Compra realizada com sucesso.",
                product.getId(),
                product.getName(),
                product.getQuantity()
        );
    }
    
}
