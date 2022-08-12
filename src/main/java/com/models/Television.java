package com.models;

import lombok.Getter;

@Getter
public class Television extends Product {

    private final double diagonal;

    public Television(String series, String screenType, double price, double diagonal) {
        super(series, screenType, price, ProductType.TELEVISION);
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Television{" +
                "series='" + series + '\'' +
                ", screenType='" + screenType + '\'' +
                ", price=" + price +
                ", type=" + type +
                "diagonal=" + diagonal +
                '}';
    }
}
