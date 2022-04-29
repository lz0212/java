package com.cy.store.service;

import com.cy.store.pojo.Address;
import com.cy.store.pojo.User;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.impl.AddressServiceImpl;
import com.cy.store.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressServiceImpl addressService;

    @Test
    public void addNewAddress(){
        Address address = new Address();
        address.setName("指针");
        address.setPhone("15588");
        address.setAddress("信电楼420");
        addressService.addNewAddress(1,"管理员",address);
    }

    @Test
    public void setDefault(){
        addressService.setDefault(10,33,"管理员");

    }

    @Test
    public void delete() {
        addressService.delete(2,1,"管理员");
    }
}
