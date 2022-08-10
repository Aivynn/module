package com.repository;

import com.models.Telephone;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TelephoneRepository implements CrudRepository<Telephone> {

    private final List<Telephone> telephones;

    private static TelephoneRepository instance;

    public static TelephoneRepository getInstance() {
        if (instance == null) {
            instance = new TelephoneRepository();
        }
        return instance;
    }

    public TelephoneRepository() {
        telephones = new LinkedList<>();
    }

    @Override
    public void save(Telephone telephone) {
        if (Optional.ofNullable(telephone).isPresent()) {
            telephones.add(telephone);
        }
        else{
            throw new IllegalArgumentException("The object is null");
        }
    }

    @Override
    public void update(Telephone telephone) {

    }

    @Override
    public void get(Telephone telephone) {

    }

    @Override
    public void delete(Telephone telephone) {

    }

    @Override
    public List<Telephone> getAll() {
        if(telephones.isEmpty()) {
            return Collections.emptyList();
        }
        return telephones;
    }
}
