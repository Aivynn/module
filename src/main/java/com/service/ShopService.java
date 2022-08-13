package com.service;

import com.models.*;
import com.repository.ShopRepository;
import com.utils.CsvFileReader;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public class ShopService<T extends Product> {

    private static final Logger LOGGER = LoggerFactory.getLogger(Invoice.class);

    private final ShopRepository repository;

    private final CsvFileReader reader;

    private static ShopService instance;

    public static ShopService getInstance() {
        if (instance == null) {
            instance = new ShopService(ShopRepository.getInstance(),new CsvFileReader());
        }
        return instance;
    }

    public ShopService(ShopRepository repository, CsvFileReader reader) {
        this.repository = repository;
        this.reader = reader;
    }

    public void createNewOrder(int invoiceCount, int limit) throws URISyntaxException, IOException {
        String file = "file.csv";
        if (limit < 0) {
            throw new IllegalStateException("Limit can't be less then 0");
        }
        List<? extends Product> products = reader.parseProduct(getFileData(file));
        Collections.shuffle(products);
        List <? extends Product> shuffledProducts = products.stream().limit(invoiceCount).collect(Collectors.toList());
        Invoice invoice = new Invoice.InvoiceBuilder(shuffledProducts,getAveragePrice(shuffledProducts))
                .customer(CustomerService.createCustomer())
                .build(limit);
        repository.save(invoice);
        LOGGER.info("Customer {} has ordered invoice {}",invoice.getCustomer(),invoice);

    }

    private double getAveragePrice(List<? extends Product> products) {
        double averagePrice = products.stream().map(Product::getPrice).reduce(Double::sum).get();
        return averagePrice;
    }

    private List<String> getFileData(String file) {
        URL reader = this.getClass().getClassLoader().getResource(file);
        Stream<String> br;
        try {
           br = Files.lines(Path.of(reader.toURI()));
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return br.toList();
    }

    public List<Invoice> getAll() {
        return repository.getAll();
    }
}