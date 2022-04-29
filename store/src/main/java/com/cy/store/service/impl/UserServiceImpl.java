package com.cy.store.service.impl;

import com.cy.store.mapper.UserMapper;
import com.cy.store.pojo.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/** 处理用户数据的业务层实现类 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public UserMapper userMapper;

    @Override
    public void save(User user) {
        String username = user.getUsername();
        User user1 = userMapper.fidByUsername(username);
        if(user1 != null) {
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }
        Date date = new Date();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setPassword(md5Password);
        // 补全数据：盐值
        user.setSalt(salt);
        // 补全数据：isDelete(0)
        user.setIsDelete(0);
        // 补全数据：4项日志属性
        user.setCreatedUser(username);
        user.setCreatedTime(date);
        user.setModifiedUser(username);
        user.setModifiedTime(date);
        int save = userMapper.save(user);
        if(save != 1) {
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }

    }

    @Override
    public User fidByUsername(String username) {
        return userMapper.fidByUsername(username);
    }

    /**
     * 用户注册
     * @param user 用户数据
     */
    @Override
    public void reg(User user) {
        // 根据参数user对象获取注册的用户名
        String username = user.getUsername();
        // 调用持久层的User findByUsername(String username)方法，根据用户名查询用户数据
        User result = userMapper.fidByUsername(username);
        // 判断查询结果是否不为null
        if (result != null) {
            // 是：表示用户名已被占用，则抛出UsernameDuplicateException异常
            throw new UsernameDuplicateException("尝试注册的用户名[" + username + "]已经被占用");
        }

        // 创建当前时间对象
        Date now = new Date();
        // 补全数据：加密后的密码
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(user.getPassword(), salt);
        user.setPassword(md5Password);
        // 补全数据：盐值
        user.setSalt(salt);
        // 补全数据：isDelete(0)
        user.setIsDelete(0);
        // 补全数据：4项日志属性
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);

        // 表示用户名没有被占用，则允许注册
        // 调用持久层Integer insert(User user)方法，执行注册并获取返回值(受影响的行数)
        Integer rows = userMapper.insert(user);
        // 判断受影响的行数是否不为1
        if (rows != 1) {
            // 是：插入数据时出现某种错误，则抛出InsertException异常
            throw new InsertException("添加用户数据出现未知错误，请联系系统管理员");
        }
    }

    /**
     * 执行密码加密
     * @param password 原始密码
     * @param salt 盐值
     * @return 加密后的密文
     */
    private String getMd5Password(String password, String salt) {
        /*
         * 加密规则：
         * 1、无视原始密码的强度
         * 2、使用UUID作为盐值，在原始密码的左右两侧拼接
         * 3、循环加密3次
         */
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

    /**
     *查找所有数据
     * @return
     */
    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    /**
     * 无加密登录
     * @param user
     * @return
     */
    @Override
    public List<User> denglu(User user) {
        String password = user.getPassword();
        password = password + "%" ;
        user.setPassword(password);

        return userMapper.denglu(user);
    }

    /**
     *加密登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username, String password) {
        User user = userMapper.fidByUsername(username);
        if(user == null) {
            throw new UserNotFoundException("用户不存在");
        }
        if(user.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        String oldPassword = user.getPassword();
        String salt = user.getSalt();
        String newMd5Password = getMd5Password(password,salt);
        if(! newMd5Password.equals(oldPassword)){
            throw new PasswordNotMatchException("密码不匹配");

        }
        User user1 = new User();
        user1.setUid(user.getUid());
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        user1.setAvatar(user.getAvatar());

        return user1;
        //return user;
    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User byUid = userMapper.findByUid(uid);
        if(byUid == null || byUid.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        String oldmd5Password = getMd5Password(oldPassword, byUid.getSalt());
        if(! byUid.getPassword().equals(oldmd5Password)) {
            throw new PasswordNotMatchException("密码错误");
        }
        String newmd5Password = getMd5Password(newPassword, byUid.getSalt());
        Integer integer = userMapper.updatePasswordByUid(uid, newmd5Password, username, new Date());
        if(integer != 1) {
            throw new UpdateException("更新时产生错误");
        }

    }

    @Override
    public User getByUid(Integer uid) {
        User byUid = userMapper.findByUid(uid);
        if(byUid == null || byUid.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        User user = new User();
        user.setUsername(byUid.getUsername());
        user.setPhone(byUid.getPhone());
        user.setEmail(byUid.getEmail());
        user.setGender(byUid.getGender());
        return user;
    }

    @Override
    public void chageInfo(Integer uid, String username, User user) {
        // 调用userMapper的findByUid()方法，根据参数uid查询用户数据
        User result = userMapper.findByUid(uid);
        // 判断查询结果是否为null
        if (result == null) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

        // 判断查询结果中的isDelete是否为1
        if (result.getIsDelete().equals(1)) {
            // 是：抛出UserNotFoundException异常
            throw new UserNotFoundException("用户数据不存在");
        }

        // 向参数user中补全数据：uid
        user.setUid(uid);
        // 向参数user中补全数据：modifiedUser(username)
        user.setModifiedUser(username);
        // 向参数user中补全数据：modifiedTime(new Date())
        user.setModifiedTime(new Date());
        // 调用userMapper的updateInfoByUid(User user)方法执行修改，并获取返回值
        Integer rows = userMapper.updateinfoByUid(user);
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException异常
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String username, String avatar) {
        User byUid = userMapper.findByUid(uid);
        if(byUid == null || byUid.getIsDelete() == 1) {
            throw new UserNotFoundException("用户不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        // 判断以上返回的受影响行数是否不为1
        if (rows != 1) {
            // 是：抛出UpdateException
            throw new UpdateException("更新用户数据时出现未知错误，请联系系统管理员");
        }
    }
}
