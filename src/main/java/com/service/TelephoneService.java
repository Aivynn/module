package com.service;

import com.models.Telephone;
import com.repository.TelephoneRepository;

import java.util.HashMap;

public class TelephoneService extends ProductService<Telephone> {

    private final TelephoneRepository repository;

    private static TelephoneService instance;

    public static TelephoneService getInstance() {
        if (instance == null) {
            instance = new TelephoneService(TelephoneRepository.getInstance());
        }
        return instance;
    }

    public TelephoneService(TelephoneRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public Telephone createAndSaveProducts(HashMap<String, Object> map) {
        return new Telephone(
                (String) map.get("series"),
                (String) map.get("model"),
                (Double) map.get("price"),
                (String) map.get("screentype"));
    }

}
