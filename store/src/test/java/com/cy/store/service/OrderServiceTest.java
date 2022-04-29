package com.cy.store.service;

import com.cy.store.pojo.District;
import com.cy.store.service.impl.DistrictServiceImpl;
import com.cy.store.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderServiceImpl orderService;
    @Test
    public void create(){
        Integer[] cids = {3,5};
        System.out.println(orderService.create(11,cids,31,"关吉吉"));

    }
}
