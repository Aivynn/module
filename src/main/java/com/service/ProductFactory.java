package com.service;

import com.models.Product;
import com.models.ProductType;
import com.models.Telephone;
import com.models.Television;
import com.utils.WrongCSVFileReadingException;


import java.util.HashMap;
import java.util.Map;

import static com.utils.CsvFileReader.HEADER_TYPE;

public class ProductFactory<T extends Product> {

    private static final TelephoneService TELEPHONE_SERVICE = TelephoneService.getInstance();
    private static final TelevisionService TELEVISION_SERVICE = TelevisionService.getInstance();

    private ProductFactory() {
    }

    public static <T extends Product>  T createAndSave(Map<String, String> map) {
        return switch (map.get(HEADER_TYPE)) {
            case "Telephone" -> (T) TELEPHONE_SERVICE.createAndSaveProducts(map);
            case "Television" -> (T) TELEVISION_SERVICE.createAndSaveProducts(map);
            default -> throw new WrongCSVFileReadingException("Unknown product type");
        };
    }
}
