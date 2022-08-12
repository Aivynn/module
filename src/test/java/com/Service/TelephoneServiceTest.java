package com.Service;

import com.models.Telephone;
import com.repository.TelephoneRepository;
import com.service.TelephoneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class TelephoneServiceTest {

    private TelephoneService target;

    private TelephoneRepository repository;

    private Telephone phone = new Telephone("AAABBB","QLED",1500.45,"xxxTOPxxx");

    @BeforeEach
    void setUp() {
        repository = mock(TelephoneRepository.class);
        target = new TelephoneService(repository);
    }

    @Test
    void createProductTest(){
        Map<String,String> map = new HashMap<>();
        map.put("series","BBBBBBB");
        map.put("screen type","QLED");
        map.put("price","1500.45");
        map.put("model","xTOP-600");
        target.createAndSaveProducts(map);
        Mockito.verify(repository,times(1)).save(any(Telephone.class));
    }



}
