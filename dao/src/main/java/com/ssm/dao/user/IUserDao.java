package com.ssm.dao.user;

import com.ssm.bean.User;

import java.util.List;

/**
 * Created by hs on 2016/12/9.
 */
public interface IUserDao {

    /**
     * 根据用户名密码获取用户
     * @param userName 用户名
     * @param password 密码
     * @return
     */
    User getUser(String userName, String password);

    /**
     * 根据用户名获取用户
     * @param userName 用户名
     * @return
     */
    public User getUser(String userName);

        /**
         * 添加用户
         * @param user
         * @return
         */
    int addUser(User user);

    /**
     * 获取所有用户列表
     * @return
     */
    List<User> getUsers();

}
