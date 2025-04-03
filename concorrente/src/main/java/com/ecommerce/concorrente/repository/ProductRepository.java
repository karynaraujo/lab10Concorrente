package com.ecommerce.concorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.concorrente.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
