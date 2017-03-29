package com.ssm.service.user.impl;

import com.common.database.pagination.DBPageHelper;
import com.common.util.encrypt.EncryptUtil;
import com.github.pagehelper.PageHelper;
import com.ssm.dao.user.IUserDao;
import com.ssm.service.user.IUserService;
import com.ssm.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by hs on 2016/12/9.
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDao userDao;


    public User login(String userName, String password) {
        // 对密码进行加密处理
        User user = userDao.getUser(userName);
        if (user == null) {
            return null;
        }
        try {
            String sha_pass = EncryptUtil.getSHA256(password + user.getSalt());
            if (sha_pass.equals(user.getPassword())) {
                return user;
            }else {
                return null;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean register(User user) {
        user.setCreateTime(new Date());
        // 生成随机salt
        Random random = new Random();
        int salt = random.nextInt(99999);
        user.setSalt(String.valueOf(salt));
        // 对密码进行加密处理
        String password = user.getPassword();
        password += salt;
        try {
            password = EncryptUtil.getSHA256(password);
            user.setPassword(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  userDao.addUser(user) > 0;
    }

    public List<User> getUserList() {
        DBPageHelper.startPageFromRequest(true);
        return userDao.getUsers();
    }
}
