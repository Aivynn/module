package com.repository;

import com.models.Television;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class TelevisionRepository implements ProductRepository<Television> {

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
        if (Optional.ofNullable(television).isPresent()) {
            televisions.add(television);
        }
        else {
            throw new IllegalArgumentException("The object is null");
        }


    }

    @Override
    public List<Television> getAll() {
        if (televisions.isEmpty()) {
            return Collections.emptyList();
        }
        return televisions;
    }

    @Override
    public Optional<Television> findById(String id) {
        Television result = null;
        for (Television television : televisions) {
            if (television.getId().equals(id)) {
                result = television;
            }
        }
        return Optional.ofNullable(result);
    }

}
