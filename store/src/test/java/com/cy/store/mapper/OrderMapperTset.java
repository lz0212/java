package com.cy.store.mapper;

import com.cy.store.pojo.District;
import com.cy.store.pojo.Order;
import com.cy.store.pojo.OrderItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class OrderMapperTset {

   @Autowired
   private OrderMapper orderMapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setUid(33);
        order.setRecvName("陈长度");
        orderMapper.insertOrder(order);

    }

    @Test
    public void insertOrderItem() {
        OrderItem orderItem = new OrderItem();
        orderItem.setOid(1);
        orderItem.setPid(10000034);
        orderItem.setTitle("（Lenovo）YOGA900绿色");
        orderMapper.insertOrderItem(orderItem);

    }
}
