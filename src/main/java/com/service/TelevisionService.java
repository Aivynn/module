package com.service;

import com.models.Telephone;
import com.models.Television;
import com.repository.TelevisionRepository;

import java.util.HashMap;

public class TelevisionService extends ProductService<Television> {

    private TelevisionRepository repository;

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

    public Television createAndSaveProducts(HashMap<String, Object> map) {
        return new Television(
                (String) map.get("series"),
                (String) map.get("model"),
                (Double) map.get("price"),
                Double.parseDouble((String) map.get("diagonal")));
    }
}
