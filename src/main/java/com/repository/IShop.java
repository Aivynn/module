package com.repository;

import java.util.List;

public interface IShop<Invoice>{

    void save(Invoice product);

    List<Invoice> getAll();
}
