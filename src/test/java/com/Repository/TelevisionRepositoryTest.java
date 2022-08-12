package com.Repository;

import com.models.Television;
import com.repository.TelevisionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


public class TelevisionRepositoryTest {

    private TelevisionRepository target;
    private Television television;

    @BeforeEach
    void setUp() {
        target = new TelevisionRepository();
        television = new Television(
                "RT-15",
                "LED",
                4634.35,
                50.35,
                "China"
        );
    }

    @Test
    void save() {
        target.save(television);
        final List<Television> phones = target.getAll();
        Assertions.assertEquals(1, phones.size());
        Assertions.assertEquals(phones.get(0).getId(), television.getId());
    }

    @Test
    void save_putNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.save(null));
        final List<Television> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }

    @Test
    void getAll() {
        target.save(television);
        final List<Television> actualResult = target.getAll();
        Assertions.assertEquals(1, actualResult.size());
    }

    @Test
    void getAll_noPhones() {
        final List<Television> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }


}
