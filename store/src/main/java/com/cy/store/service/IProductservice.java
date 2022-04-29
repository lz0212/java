package com.cy.store.service;

import com.cy.store.pojo.Product;

import java.util.List;

public interface IProductservice {

    List<Product> findHotList();

    Product findById(Integer id);
}
