package com.Commands;

import com.service.ShopService;

import java.io.IOException;
import java.net.URISyntaxException;

public class Create implements Command {

    private final static ShopService SHOP_SERVICE = ShopService.getInstance();
    public Create(){

    }

    @Override
    public void execute() throws URISyntaxException, IOException {
        SHOP_SERVICE.createNewOrder();
        ConsoleMenu.menu(Commands.values());
    }
}
