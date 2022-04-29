package com.cy.store.controller;

import com.cy.store.pojo.Address;
import com.cy.store.pojo.District;
import com.cy.store.service.impl.AddressServiceImpl;
import com.cy.store.service.impl.DistrictServiceImpl;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController{

    @Autowired
    private DistrictServiceImpl districtService;


    @RequestMapping({"/",""})
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }


}
