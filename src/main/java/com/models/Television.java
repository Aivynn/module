package com.models;

public class Television extends Product {

    private double diagonal;

    public Television(String series, String screenType, double price, double diagonal) {
        super(series, screenType, price, ProductType.TELEVISION);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Television{" +
                "diagonal=" + diagonal +
                '}';
    }
}
