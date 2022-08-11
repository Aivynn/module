package com.service;

import com.models.Invoice;
import com.models.Product;
import com.models.ProductType;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class StreamExamples {

    private final static ShopService<? extends Product> SHOP_SERVICE = ShopService.getInstance();

    public static void quantity() {
        long telephones = SHOP_SERVICE.getAll()
                .stream()
                .map(Invoice::getProducts)
                .flatMap(Collection::stream)
                .filter(x -> x.getType().equals(ProductType.TELEPHONE))
                .count();
        long televisions = SHOP_SERVICE.getAll()
                .stream()
                .map(Invoice::getProducts)
                .flatMap(Collection::stream)
                .filter(x -> x.getType().equals(ProductType.TELEVISION))
                .count();

        System.out.printf("Were bought %d telephones and %d televisions", telephones, televisions);
        System.out.println();
    }

    public static void minOrder() {
        Optional<Invoice> target = SHOP_SERVICE.getAll().stream().min(Comparator.comparingDouble(Invoice::getTotalPrice));
        System.out.println(target.get().getTotalPrice() + " " + target.get().getCustomer());
    }

    public static void profit() {
        double profit = SHOP_SERVICE.getAll().stream().mapToDouble(Invoice::getTotalPrice).sum();
        System.out.println("The all orders profit is " + profit);
    }

    public static void similarTypes(ProductType type) {
        List<Invoice> similarTypes = SHOP_SERVICE.getAll().
                stream()
                .filter(x -> x.getProducts().stream().allMatch(t -> t.getType().equals(type)))
                .toList();
        if (similarTypes.size() > 0) {
            similarTypes.forEach(System.out::println);
        } else {
            System.out.println("No such invoices");
        }
    }

    public static void lowAge() {
        SHOP_SERVICE.getAll()
                .stream()
                .filter(x -> x.getCustomer().getAge() < 18)
                .forEach(System.out::println);
    }

    public static void lastOrders() {
        List<LocalDateTime> time = SHOP_SERVICE.getAll().stream()
                .map(Invoice::getTime)
                .sorted()
                .toList();
        time.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    public static void sortedInvoices() {
        List<Invoice> sortedOrders = SHOP_SERVICE.getAll().stream().sorted(new Comparator<Invoice>() {
            @Override
            public int compare(Invoice o1, Invoice o2) {
                int ageCompare = o2.getCustomer().compareTo(o1.getCustomer());
                int orderCompare = o2.compareTo(o1);
                int orderPriceCompare = o2.getTotalPrice().compareTo(o1.getTotalPrice());

                if (ageCompare == 0) {
                    return orderCompare == 0 ? orderPriceCompare : orderCompare;
                } else {
                    return ageCompare;
                }

            }
        }).toList();
        sortedOrders.forEach(System.out::println);
    }
}