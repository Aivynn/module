package com;


import com.Commands.Commands;
import com.Commands.ConsoleMenu;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        final Commands[] commands = Commands.values();
        ConsoleMenu.menu(commands);
    }
}