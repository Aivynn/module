package com.Service;

import com.models.Television;
import com.repository.TelevisionRepository;
import com.service.TelevisionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class TelevisionServiceTest {

    private TelevisionService target;

    private TelevisionRepository repository;

    private Television television = new Television("AAABBB","QLED",1500.45,35.50,"China");

    @BeforeEach
    void setUp() {
        repository = mock(TelevisionRepository.class);
        target = new TelevisionService(repository);
    }

    @Test
    void createProductTest(){
        Map<String,String> map = new HashMap<>();
        map.put("series","BBBBBBB");
        map.put("screen type","QLED");
        map.put("price","1500.45");
        map.put("diagonal","60.35");
        target.createAndSaveProducts(map);
        Mockito.verify(repository,times(1)).save(any(Television.class));
    }
}
