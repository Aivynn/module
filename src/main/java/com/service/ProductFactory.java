package com.service;

import com.models.Product;
import com.models.ProductType;
import com.models.Telephone;
import com.models.Television;


import java.util.HashMap;

public class ProductFactory<T extends Product> {

    private static final TelephoneService TELEPHONE_SERVICE = TelephoneService.getInstance();
    private static final TelevisionService TELEVISION_SERVICE = TelevisionService.getInstance();

    private ProductFactory() {
    }

    public static <T extends Product>  T createAndSave(ProductType type, HashMap<String, Object> map) {
        return switch (type) {
            case TELEPHONE -> (T) TELEPHONE_SERVICE.createAndSaveProducts(map);
            case TELEVISION -> (T) TELEVISION_SERVICE.createAndSaveProducts(map);
        };
    }
}
