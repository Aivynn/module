package com.Repository;

import com.models.Telephone;
import com.repository.TelephoneRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;


public class TelephoneRepositoryTest {

    private TelephoneRepository target;
    private Telephone phone;

    @BeforeEach
    void setUp() {
        target = new TelephoneRepository();
        phone = new Telephone(
                "RT-15",
                "LED",
                4634.35,
                "xxxSUPERTOPxxx"
        );
    }

    @Test
    void save() {
        target.save(phone);
        final List<Telephone> phones = target.getAll();
        Assertions.assertEquals(1, phones.size());
        Assertions.assertEquals(phones.get(0).getId(), phone.getId());
    }

    @Test
    void save_putNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.save(null));
        final List<Telephone> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }

    @Test
    void findById() {
        target.save(phone);
        final Optional<Telephone> optionalPhone = target.findById(phone.getId());
        Assertions.assertTrue(optionalPhone.isPresent());
        final Telephone actualPhone = optionalPhone.get();
        Assertions.assertEquals(phone.getId(), actualPhone.getId());
    }

    @Test
    void getAll() {
        target.save(phone);
        final List<Telephone> actualResult = target.getAll();
        Assertions.assertEquals(1, actualResult.size());
    }

    @Test
    void getAll_noPhones() {
        final List<Telephone> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }


}
