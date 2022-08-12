package com;


import com.Commands.Commands;
import com.Commands.ConsoleMenu;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.Commands.Command.SCANNER;

public class Main {

    public static Integer LIMIT;

    public static void main(String[] args) throws URISyntaxException, IOException {

        System.out.println("Enter the tax-free amount: ");
        LIMIT = SCANNER.nextInt();
        final Commands[] commands = Commands.values();
        ConsoleMenu.menu(commands);
    }
}