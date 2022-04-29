package com.cy.store.mapper;

import com.cy.store.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 用户模块的持久层接口
 */
@Mapper
public interface UserMapper {

    /**
     * 插入用户的数据
     *
     * @param user 用户数据
     * @return 受影响的行数（增删改都有）
     */
    int insert(User user);

    int save(User user);

    /**
     * 根据用户名查询用户数据
     *
     * @param username 用户名
     * @return 匹配的用户数据，如果没有匹配的数据，则返回null
     */
    User fidByUsername(String username);

    //    List<User> denglu(@Param("username") String username,@Param("password") String password);
    List<User> denglu(User user);

    List<User> getAll();

    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);
    User findByUid(Integer uid);

    Integer updateinfoByUid(User user);

    /**
     * 根据uid更新用户的头像
     * @param uid 用户的id
     * @param avatar 新头像的路径
     * @param modifiedUser 修改执行人
     * @param modifiedTime 修改时间
     * @return 受影响的行数
     */
    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime);
}
