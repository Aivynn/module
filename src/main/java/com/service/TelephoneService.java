package com.service;

import com.models.Telephone;
import com.repository.TelephoneRepository;

import java.util.Map;

import static com.utils.CsvFileReader.*;

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

    public Telephone createAndSaveProducts(Map<String, String> map) {
        Telephone phone = new Telephone(
                map.get(HEADER_SERIES),
                map.get(HEADER_SCREEN_TYPE),
                Double.parseDouble(map.get(HEADER_PRICE)),
                map.get(HEADER_MODEL));
        repository.save(phone);
        return phone;
    }

}
