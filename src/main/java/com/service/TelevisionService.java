package com.service;

import com.models.Television;
import com.repository.TelevisionRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.utils.CsvFileReader.*;

public class TelevisionService extends ProductService<Television> {

    private final TelevisionRepository repository;

    private static TelevisionService instance;

    public static TelevisionService getInstance() {
        if (instance == null) {
            instance = new TelevisionService(TelevisionRepository.getInstance());
        }
        return instance;
    }

    public TelevisionService(TelevisionRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Television createAndSaveProducts(Map<String, String> map) {
        Television television = new Television(
                Optional.of(map.get(HEADER_SERIES)).get(),
                Optional.of(map.get(HEADER_SCREEN_TYPE)).get(),
                Optional.of(Double.parseDouble(map.get(HEADER_PRICE))).get(),
                Optional.of(Double.parseDouble(map.get(HEADER_DIAGONAL))).get(),
                Optional.of(map.get(HEADER_COUNTRY)).get());
        repository.save(television);
        return television;
    }
}
