package com.ecommerce.concorrente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.concorrente.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
