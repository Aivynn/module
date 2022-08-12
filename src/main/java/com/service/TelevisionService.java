package com.service;

import com.models.Television;
import com.repository.TelevisionRepository;

import java.util.HashMap;
import java.util.Map;

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
                map.get(HEADER_SERIES),
                map.get(HEADER_SCREEN_TYPE),
                Double.parseDouble(map.get(HEADER_PRICE)),
                Double.parseDouble(map.get(HEADER_DIAGONAL)),
                map.get(HEADER_COUNTRY));
        repository.save(television);
        return television;
    }
}
