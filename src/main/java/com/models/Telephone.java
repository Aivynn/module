package com.models;

public class Telephone extends Product {

    private final String model;

    public Telephone(String series, String screenType, double price, String model) {
        super(series, screenType, price, ProductType.TELEPHONE);
        this.model = model;
    }

    @Override
    public String toString() {
        return "Telephone{" +
                "model='" + model + '\'' +
                '}';
    }
}
