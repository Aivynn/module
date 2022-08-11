package com.Commands;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public interface Command {
    void execute() throws URISyntaxException, IOException;

    Scanner SCANNER = new Scanner(System.in);
}
