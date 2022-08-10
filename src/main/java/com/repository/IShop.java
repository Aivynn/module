package com.repository;

import java.util.List;

public interface IShop<Invoice>{

    public void save(Invoice product);

    List<Invoice> getAll();

    public void printAll();
}
