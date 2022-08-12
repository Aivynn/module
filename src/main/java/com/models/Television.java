package com.models;

import lombok.Getter;

@Getter
public class Television extends Product {

    private final double diagonal;

    private final String country;

    public Television(String series, String screenType, double price, double diagonal, String country) {
        super(series, screenType, price, ProductType.TELEVISION);
        this.diagonal = diagonal;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Television{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", country=" + country +
                ", diagonal=" + diagonal +
                '}';
    }
}
