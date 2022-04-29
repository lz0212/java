package com.cy.store.service;

import com.cy.store.pojo.Address;
import com.cy.store.pojo.District;
import com.cy.store.service.impl.AddressServiceImpl;
import com.cy.store.service.impl.DistrictServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictServiceTest {

    @Autowired
    private DistrictServiceImpl districtService;

    @Test
    public void getByParent(){
        List<District> dis = districtService.getByParent("86");
        for(District d : dis) {
            System.out.println(d);
        }

    }
}
