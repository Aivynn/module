package com.Commands;

import lombok.Getter;

@Getter
public enum Commands {
    CREATE("Create new order", new Create()),
    INFO("Get info about orders", new Total()),
    EXIT("Exit", null);

    private final String string;
    private final Command command;

    Commands(String string, Command command) {
        this.string = string;
        this.command = command;

    }
}
