package com.models;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Invoice implements Comparable<Invoice> {
    private final List<? extends Product> products;
    private final Customer customer;

    private final Double totalPrice;
    private Types type;
    private final LocalDateTime time;

    private Invoice(InvoiceBuilder builder) {
        this.products = builder.products;
        this.customer = builder.customer;
        this.type = builder.types;
        this.totalPrice = builder.price;
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customer=" + customer +
                ",products=" + products +
                ",price=" + totalPrice +
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
        private final Double price;

        private Types types;
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
            validate(limit);
            return new Invoice(this);

        }

        private InvoiceBuilder type(Types types) {
            this.types = types;
            return this;
        }

        private void validate(int limit) {
            if (limit < price) {
                type(Types.WHOLESALE);
            }
            else {
                type(Types.RETAIL);
            }

            if (customer.getAge() < 18){
                type(Types.LOW_AGE);
            }
        }
    }
}
