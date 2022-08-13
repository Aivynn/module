package com.Service;

import com.models.Telephone;
import com.repository.TelephoneRepository;
import com.service.TelephoneService;
import com.utils.WrongCSVFileReadingException;
import org.junit.jupiter.api.Assertions;
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

   private final Map<String,String> map = new HashMap<>();
    private TelephoneRepository repository;


    @BeforeEach
    void setUp() {
        repository = mock(TelephoneRepository.class);
        target = new TelephoneService(repository);
        map.put("series","BBBBBBB");
        map.put("screen type","QLED");
        map.put("price","1500.45");
        map.put("diagonal","null");
        map.put("country","null");
        map.put("model","null");
    }

    @Test
    void createProductTest(){
        target.createAndSaveProducts(map);
        Mockito.verify(repository,times(1)).save(any(Telephone.class));
    }
    @Test
    void createProductTestWrongHeaders(){
        Map<String,String> wrongTagMap = new HashMap<>();
        wrongTagMap.put("series","BBBBBBB");
        wrongTagMap.put("screen-types","QLED");
        wrongTagMap.put("price","1500.45");
        wrongTagMap.put("diagonal","null");
        wrongTagMap.put("country","null");
        wrongTagMap.put("model","X-1337");
        Assertions.assertThrows(RuntimeException.class, () -> target.createAndSaveProducts(wrongTagMap));
    }



}
