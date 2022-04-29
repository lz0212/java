package com.cy.store.mapper;

import com.cy.store.pojo.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class AddressMapperTset {

    @Autowired
    public AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(1);
        address.setAddress("浙江工商大学");
        addressMapper.insert(address);
    }

    ;

    @Test
    public void countByUid() {
        System.out.println(addressMapper.countByUid(1));
    }

    ;

    @Test
    public void findByUid() {
        System.out.println(addressMapper.findByUid(33));
    }

    ;

    @Test
    public void findByAid() {
        System.out.println(addressMapper.findByAid(1));
    }

    @Test
    public void updateNonDefaultByUid() {
        addressMapper.updateNonDefaultByUid(31);
    }

    @Test
    public void updateDefaultByAid() {
        addressMapper.updateDefaultByAid(5, "陈华", new Date());
    }

    @Test
    public void deleteByAid() {
        addressMapper.deleteByAid(1);
    }

    @Test
    public void findLastModified() {
        System.out.println( addressMapper.findLastModified(33));
    }
}
