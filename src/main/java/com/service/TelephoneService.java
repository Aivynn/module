package com.service;

import com.models.Telephone;
import com.repository.TelephoneRepository;
import com.utils.WrongCSVFileReadingException;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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
                Optional.of(map.get(HEADER_SERIES)).get(),
                Optional.of(map.get(HEADER_SCREEN_TYPE)).get(),
                Optional.of(Double.parseDouble(map.get(HEADER_PRICE))).get(),
                Optional.of(map.get(HEADER_MODEL)).get());
        repository.save(phone);
        return phone;
    }

}
