package com.utils;

import com.Commands.Command;
import com.Commands.Commands;
import com.Commands.ConsoleMenu;
import com.models.ProductType;
import com.models.Types;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.Commands.Command.SCANNER;

public class TypesReader {

    public static ProductType menu(final ProductType[] values) throws URISyntaxException, IOException {

        int userCommand = -1;
        do {
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i, values[i]);
            }
            int input = SCANNER.nextInt();
            if (input >= 0 && input < values.length) {
                userCommand = input;
            }
        } while (userCommand == -1);
        final ProductType type;
        type = values[userCommand];
        if (type != null) {
            return type;
        }
        else {
            TypesReader.menu(ProductType.values());
        }
        return type;
    }
}
