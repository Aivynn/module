package com.Commands;

import com.service.ShopService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Random;

import static com.Main.LIMIT;

public class Create implements Command {

    private final static ShopService SHOP_SERVICE = ShopService.getInstance();

    public Create() {

    }

    @Override
    public void execute() throws URISyntaxException, IOException {
        Random random = new Random();
        int i = 0;
        while (i < 15) {
            SHOP_SERVICE.createNewOrder(random.nextInt(1, 5), LIMIT);
            i++;
        }

        ConsoleMenu.menu(Commands.values());
    }
}
