package com.service;

import com.models.*;
import com.repository.ShopRepository;
import com.repository.TelephoneRepository;
import com.utils.CsvFileReader;
import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

@Getter
public class ShopService<T extends Product> {

    private final ShopRepository repository;

    private static ShopService instance;

    public static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopService(ShopRepository.getInstance());
        }
        return instance;
    }

    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public void createNewOrder() throws URISyntaxException, IOException {
        int i = 0;
        Random random = new Random();
        int bucket = random.nextInt(1, 5);
        List<T> products = new LinkedList<>();
        CsvFileReader reader = new CsvFileReader();
        List<HashMap<String, Object>> map = reader.parseProduct();
        while (i < bucket) {
            int randomProduct = random.nextInt(1, map.size());
            products.add(ProductFactory.createAndSave((ProductType) map.get(randomProduct).get("type"), map.get(randomProduct)));
            i++;
        }
        double averagePrice = products.stream().map(Product::getPrice).reduce(Double::sum).get();
        Invoice invoice = new Invoice(products, CustomerService.createCustomer(), Types.WHOLESALE, averagePrice);
        repository.save(invoice);
    }

    public List<Invoice> getAll() {
        return repository.getAll();
    }
    public void printAll() {
       repository.getAll().forEach(System.out::println);
    }
}