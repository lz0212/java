package com.cy.store.service;

import com.cy.store.mapper.UserMapper;
import com.cy.store.pojo.User;
import com.cy.store.service.ex.ServiceException;
import com.cy.store.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("user04");
            user.setPassword("123457");
            userService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void save() {
        try {
            User user = new User();
            user.setUsername("test24");
            user.setPassword("123");
            userService.save(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getAll() {
        System.out.println(userService.getAll());
    }

    @Test
    public void fidByUsername() {
        String username = "user";
        System.out.println(userService.fidByUsername(username));

    }

    @Test
    public void denglu() {
        User user = new User();
        String password = "1234";
        password = password + "%";
        user.setUsername("user02");
        user.setPassword(password);
        System.out.println(userService.denglu(user));

    }

    @Test
    public void login(){
        System.out.println(userService.login("test","123"));
    }

    @Test
    public void changePassword() {
        try {
            Integer uid = 5;
            String username = "test4";
            String oldPassword = "321";
            String newPassword = "123";
            userService.changePassword(uid, username, oldPassword, newPassword);
            System.out.println("密码修改成功！");
        } catch (ServiceException e) {
            System.out.println("密码修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getByUid() {
        System.out.println(userService.getByUid(22));
    }

    @Test
    public void changeInfo() {
        try {
            Integer uid = 30;
            String username = "数据管理员";
            User user = new User();
            user.setPhone("15512328888");
            user.setEmail("admin03@cy.cn");
            user.setGender(2);
            userService.chageInfo(uid, username, user);
            System.out.println("OK.");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changeAvatar() {
        userService.changeAvatar(32,"/kiih","小华");
    }

}
