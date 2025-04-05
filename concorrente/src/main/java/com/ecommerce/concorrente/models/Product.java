package com.ecommerce.concorrente.models;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    
    @Id
    private final String id;
    private final String name;
    private final double price;
    private final AtomicInteger quantity;

    public Product(String id, String name, double price, int initialQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = new AtomicInteger(initialQuantity);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity.get(); }

    public boolean decreaseStock(int amount) {
        while (true) {
            int current = quantity.get();
            if (current < amount) return false;
            if (quantity.compareAndSet(current, current - amount)) return true;
        }
    }

    public void updateStock(int newQuantity) {
        quantity.set(newQuantity);
    }

    public void increaseStock(int amount) {
        quantity.addAndGet(amount);
    }
    
}
