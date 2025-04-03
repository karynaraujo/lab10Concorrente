package com.ecommerce.concorrente.service;
import java.util.List;

import com.ecommerce.concorrente.models.Sale;
import com.ecommerce.concorrente.repository.SaleRepository;

public class SaleService {

    private final SaleRepository saleRepository;


      public SaleService(SaleRepository saleRepository){  //nao sei se precisa isso aqui
        this.saleRepository = saleRepository;
    }


    public List<Sale> getAllSales(){
        return saleRepository.findAll();
        

    }
    
}
