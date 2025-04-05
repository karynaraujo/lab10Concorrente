package com.ecommerce.concorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.concorrente.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    
}
