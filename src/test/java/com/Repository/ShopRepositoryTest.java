package com.Repository;

import com.models.Customer;
import com.models.Invoice;
import com.models.Telephone;
import com.models.Television;
import com.repository.ShopRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ShopRepositoryTest {
    private ShopRepository target;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        target = new ShopRepository();
        invoice = new Invoice.InvoiceBuilder(
               List.of(new Telephone(
                       "RT-15",
                       "LED",
                       4634.35,
                       "xxxSUPERTOPxxx"),
                       new Television(
                       "RT-15",
                       "LED",
                       4634.35,
                       50.35,
                       "China")),
                       2500.34)
                .customer(new Customer("vasek2281337@gmail.com",44))
                .build(500);
    }

    @Test
    void save(){
        target.save(invoice);
        final List<Invoice> phones = target.getAll();
        Assertions.assertEquals(1, phones.size());
    }
    @Test
    void save_Null() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.save(null));
        final List<Invoice> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }
    @Test
    void getAll() {
        target.save(invoice);
        final List<Invoice> actualResult = target.getAll();
        Assertions.assertEquals(1, actualResult.size());
    }

    @Test
    void getAll_noInvoices() {
        final List<Invoice> actualResult = target.getAll();
        Assertions.assertEquals(0, actualResult.size());
    }
}
