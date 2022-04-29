package com.cy.store.controller;


import com.cy.store.pojo.Product;
import com.cy.store.service.impl.ProductserviceImpl;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController extends BaseController{
    @Autowired
    private ProductserviceImpl productservice;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>>  getHotList(){
        return new JsonResult<>(OK, productservice.findHotList());
    }


    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        return new JsonResult<>(OK, productservice.findById(id));
    }
}
