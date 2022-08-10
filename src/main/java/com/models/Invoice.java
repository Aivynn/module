package com.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Invoice implements Comparable<Invoice>{
    private final List<? extends Product> products;
    private final Customer customer;

    private final Double totalPrice;
    private Types type;
    private final LocalDateTime time;

    public Invoice(List<? extends Product> products, Customer customer, Types type, Double totalPrice) {
        this.products = products;
        this.customer = customer;
        this.type = type;
        this.totalPrice = totalPrice;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "products=" + products +
                ", customer=" + customer +
                ", type=" + type +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Invoice o) {
        return this.getProducts().size() - o.getProducts().size();
    }
}
