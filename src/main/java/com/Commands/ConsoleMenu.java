package com.Commands;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.Commands.Command.SCANNER;

public class ConsoleMenu {

    public static boolean menu(final Commands[] values) throws URISyntaxException, IOException {

        int userCommand = -1;
        do {
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i, values[i].getString());
            }
            int input = SCANNER.nextInt();
            if (input >= 0 && input < values.length) {
                userCommand = input;
            }
        } while (userCommand == -1);
        final Command command;
        command = values[userCommand].getCommand();
        if (command == null) {
            return true;
        } else {
            command.execute();
            return false;
        }

    }
}
