package com.Service;

import com.models.Customer;
import com.models.Invoice;
import com.models.Telephone;
import com.models.Television;
import com.repository.ShopRepository;
import com.service.ShopService;
import com.utils.CsvFileReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.mockito.Mockito.mock;

public class ShopServiceTest {

    private final static Invoice invoice = new Invoice.InvoiceBuilder(
            List.of(new Telephone(
                            "RT-15",
                            "LED",
                            4634.35,
                            "xxxSUPERTOPxxx"),
                    new Television(
                            "RT-15",
                            "LED",
                            4634.35,
                            50.35)),
            2500.34)
            .customer(new Customer("vasek2281337@gmail.com", 44))
            .build(500);

    private ShopService target;

    private ShopRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(ShopRepository.class);
        target = new ShopService(repository, new CsvFileReader());
    }

    @Test
    void createOrder() throws URISyntaxException, IOException {

        int count = 5;
        target.createNewOrder(count, 500);

        ArgumentCaptor<Invoice> argumentCaptor = ArgumentCaptor.forClass((Class) Invoice.class);
        Mockito.verify(repository).save(argumentCaptor.capture());
        Assertions.assertEquals(count, argumentCaptor.getValue().getProducts().size());

    }

    @Test
    void orderLimitLessThenZero() {

        Assertions.assertThrows(IllegalStateException.class, () -> target.createNewOrder(3, -5));

    }

}
