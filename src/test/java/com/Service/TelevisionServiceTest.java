package com.Service;

import com.models.Telephone;
import com.models.Television;
import com.repository.TelevisionRepository;
import com.service.TelevisionService;
import com.utils.WrongCSVFileReadingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static com.utils.CsvFileReader.*;
import static com.utils.CsvFileReader.HEADER_MODEL;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class TelevisionServiceTest {

    private TelevisionService target;

    private final Map<String, String> map = new HashMap<>();
    private TelevisionRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(TelevisionRepository.class);
        target = new TelevisionService(repository);
        map.put("series", "BBBBBBB");
        map.put("screen type", "QLED");
        map.put("price", "1500.45");
        map.put("diagonal", "36.54");
        map.put("country", "China");
        map.put("model", "null");
    }

    @Test
    void createProductTest() {
        target.createAndSaveProducts(map);
        Mockito.verify(repository, times(1)).save(any(Television.class));
    }

    @Test
    void createProductTestFail() {
        Map<String, String> wrongTagMap = new HashMap<>();
        wrongTagMap.put("series", "BBBBBBB");
        wrongTagMap.put("screentype", "QLED");
        wrongTagMap.put("price", "1500.45");
        wrongTagMap.put("diagonal", "xTOP-600");
        wrongTagMap.put("country", "China");
        Assertions.assertThrows(RuntimeException.class, () -> target.createAndSaveProducts(wrongTagMap));
    }

}
