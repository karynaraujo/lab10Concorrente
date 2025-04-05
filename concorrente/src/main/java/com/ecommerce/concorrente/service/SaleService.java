package com.ecommerce.concorrente.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.concorrente.models.Sale;
import com.ecommerce.concorrente.repository.SaleRepository;

@Service
public class SaleService {

    private final SaleRepository saleRepository;


      public SaleService(SaleRepository saleRepository){  //nao sei se precisa isso aqui
        this.saleRepository = saleRepository;
    }


    public List<Sale> getAllSales(){
        return saleRepository.findAll();
        

    }

    public void mockRegisterSale(String productId, int quantity) {
        System.out.println("Mock: Registrando venda de " + quantity + " unidade(s) do produto " + productId);
    }
    
    
}
