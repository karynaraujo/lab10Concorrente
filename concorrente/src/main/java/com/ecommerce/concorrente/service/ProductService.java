package com.ecommerce.concorrente.service;
import java.util.List;

import com.ecommerce.concorrente.models.Product;
import com.ecommerce.concorrente.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository){  //nao sei se precisa isso aqui
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts(){
        return productRepository.findAll();
        

    }

    
}
