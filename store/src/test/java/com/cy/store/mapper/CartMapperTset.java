package com.cy.store.mapper;

import com.cy.store.pojo.Cart;
import com.cy.store.pojo.District;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class CartMapperTset {

    @Autowired
    public CartMapper cartMapper;

    @Test
    public void insert(){
        Cart cart = new Cart();
        cart.setUid(33);
        cart.setPid(10000033);
        cart.setNum(1);
        cart.setPrice(1025L);
        cartMapper.insert(cart);
    }

    @Test
    public void updateNumByCid(){
       cartMapper.updateNumByCid(1,2,"车红飞",new Date());
    }

    @Test
    public void findByUidAndPid(){
        System.out.println(cartMapper.findByUidAndPid(31,10000007));
    }

    @Test
    public void findVOByUid() {
        System.out.println(cartMapper.findVOByUid(31));
    }

    @Test
    public void findByCid(){
        System.out.println(cartMapper.findByCid(3));
    }

    @Test
    public void findVOByCids() {
        Integer[] cids = {1,3,5};
        System.out.println(cartMapper.findVOByCids(cids));
    }

}
