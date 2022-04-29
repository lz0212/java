package com.cy.store.mapper;

import com.cy.store.pojo.Address;
import com.cy.store.pojo.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DistrictMapperTset {

    @Autowired
    public DistrictMapper districtMapper;

    @Test
    public void findByParent() {
        List<District> dis = districtMapper.findByParent("210100");
        for(District d : dis) {
            System.out.println(d);
        }
    }

    @Test
    public void findNameByCode() {
        String code = "540000";
        String name = districtMapper.findNameByCode(code);
        System.out.println(name);
    }
}
