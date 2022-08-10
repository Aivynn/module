package com.repository;

import com.models.Telephone;
import com.models.Television;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TelevisionRepository implements CrudRepository<Television> {

    private final List<Television> televisions;

    private static TelevisionRepository instance;

    public static TelevisionRepository getInstance() {
        if (instance == null) {
            instance = new TelevisionRepository();
        }
        return instance;
    }

    public TelevisionRepository() {
        televisions = new LinkedList<>();
    }

    @Override
    public void save(Television television) {
        Optional<Television> television1 = Optional.of(television);
        if (television1.isPresent()) {
            televisions.add(television);
        }


    }

    @Override
    public void update(Television television) {

    }

    @Override
    public void get(Television television) {

    }

    @Override
    public void delete(Television television) {

    }

    @Override
    public List<Television> getAll() {
        if (televisions.isEmpty()) {
            return Collections.emptyList();
        }
        return televisions;
    }

}
