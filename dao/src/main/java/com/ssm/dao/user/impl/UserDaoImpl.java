package com.ssm.dao.user.impl;

import com.ssm.bean.User;
import com.ssm.dao.user.IUserDao;
import com.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hs on 2016/12/9.
 */
@Repository
public class UserDaoImpl implements IUserDao {

    @Autowired
    UserMapper userMapper;

    public User getUser(String userName, String passWord) {
        return userMapper.selectByUserNameAndPassword(userName, passWord);
    }

    public User getUser(String userName) {
        return userMapper.selectByUserName(userName);
    }

    public List<User> getUsers() {
        return userMapper.selectAllUsers();
    }

    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
