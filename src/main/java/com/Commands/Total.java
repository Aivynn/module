package com.Commands;

import com.models.ProductType;
import com.utils.StreamExamples;
import com.utils.TypesReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Total implements Command {

    @Override
    public void execute() throws URISyntaxException, IOException {
        StreamExamples.sortedInvoices();
        System.out.println("----------------------------------------------------------------");
        StreamExamples.lastOrders();
        System.out.println("----------------------------------------------------------------");
        StreamExamples.quantity();
        System.out.println("----------------------------------------------------------------");
        StreamExamples.profit();
        System.out.println("----------------------------------------------------------------");
        StreamExamples.lowAge();
        System.out.println("----------------------------------------------------------------");
        StreamExamples.minOrder();
        System.out.println("----------------------------------------------------------------");
        ProductType type = TypesReader.menu(ProductType.values());
        StreamExamples.similarTypes(type);
        ConsoleMenu.menu(Commands.values());
    }
}
