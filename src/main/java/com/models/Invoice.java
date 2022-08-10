package com.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Invoice implements Comparable<Invoice> {
    private final List<? extends Product> products;
    private final Customer customer;

    private final Double totalPrice;
    private Types type;
    private final LocalDateTime time;

    private Invoice(InvoiceBuilder builder) {
        this.products = builder.products;
        this.customer = builder.customer;
        this.type = builder.type;
        this.totalPrice = builder.price;
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

    public static class InvoiceBuilder {

        private Customer customer;
        private Double price;

        private Types type;
        private final List<? extends Product> products;

        public InvoiceBuilder(List<? extends Product> products, Double price) {
            this.products = products;
            this.price = price;
        }

        public InvoiceBuilder customer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Invoice build(int limit) {
            Invoice invoice = new Invoice(this);
            validate(limit);
            return invoice;

        }

        private void validate(int limit) {
            if (limit < price) {
                type = Types.WHOLESALE;
            } else {
                type = Types.RETAIL;
            }
        }
    }
}
