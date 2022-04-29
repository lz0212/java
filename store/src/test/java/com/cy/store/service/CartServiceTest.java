package com.cy.store.service;

import com.cy.store.pojo.District;
import com.cy.store.service.impl.CartServiceImpl;
import com.cy.store.service.impl.DistrictServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CartServiceTest {

    @Autowired
    private CartServiceImpl cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(1,10000003,3,"陈虎虎");
    }
}
