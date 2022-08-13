package com.utils;

import com.models.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;


public class CsvParserTest {

    private List<String> lines;
    private CsvFileReader target;

    @BeforeEach
    void setUp() {
        lines = List.of(("type,series,model,diagonal,screen type,country,price"),
                ("Telephone,S-10,Samsung,none,QLED,none,2001"),
                ("Television,RTI-14,none,25,LED,China,15002"));
        target = new CsvFileReader();
    }


    @Test
    void parseProduct(){
        List<? extends Product> product = target.parseProduct(lines);
        Assertions.assertEquals(2,product.size());
    }

    @Test
    void parseProductIllegalLine(){
        List<String> line = List.of(("type,series,model,diagonal,screen type,country,price"),
                ("Telephone,S-10,,none,QLED,none,2001"),
                ("Television,RTI-14,none,25,LED,China,15002"));
        List<? extends Product> product = target.parseProduct(line);
        Assertions.assertEquals(1,product.size());

    }

}
