package com.cy.store.controller;


import com.cy.store.pojo.Order;
import com.cy.store.service.impl.OrderServiceImpl;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("orders")
public class OrderController extends BaseController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping("/create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session) {
        return new JsonResult<>(OK, orderService.create(aid,
                                                        cids,
                                                        getUidFromSession(session),
                                                        getUsernameFromSession(session)));

    }
}
