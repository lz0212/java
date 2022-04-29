package com.cy.store.mapper;

import com.cy.store.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserMapeerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("user568");
        user.setPassword("123456");
        user.setCreatedUser("陈虎");
        System.out.println(userMapper.insert(user));
    }

    @Test
    public void fidByUsername() {

        System.out.println(userMapper.fidByUsername("user01"));
    }

    @Test
    public void getAll() {
        System.out.println(userMapper.getAll());
    }

    @Test
    public void updatePasswordByUid() {
        Integer uid = 7;
        String password = "654321";
        String modifiedUser = "普通管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 7;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(20);
        user.setPhone("17858802222");
        user.setEmail("admin@cy.com");
        user.setGender(1);
        user.setModifiedUser("系统管理员");
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateinfoByUid(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(22,"/4848","lz",new Date());
    }
}
