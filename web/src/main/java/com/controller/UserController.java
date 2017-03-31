package com.controller;

import com.common.entity.api.ApiResult;
import com.common.entity.api.ApiResultUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.ssm.bean.User;
import com.ssm.service.user.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hs on 2016/12/8.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    IUserService userService;

    @RequestMapping(value = "/home")
    public ModelAndView loginView() {
        ModelAndView view = new ModelAndView("user/login");
        return view;
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(String userName, String passWord) {
        ModelAndView view = new ModelAndView();
        User user = userService.login(userName, passWord);
        if (user == null) {
            view.setViewName("user/login");
            view.addObject("msg", "用户名或密码错误");
        }else {
            view.setViewName("main");
            view.addObject("user", user);
        }
        return view;
    }

    @RequestMapping(value = "/registerPage")
    public ModelAndView registerPage() {
        return new ModelAndView("user/register");
    }

    @RequestMapping(value = "/register")
    public ModelAndView register(User user) {
        ModelAndView view = new ModelAndView();
        boolean result = userService.register(user);
        if (result) {
            view.setViewName("user/login");
        }
        else {
            view.setViewName("user/register");
        }
        return view;
    }

    @RequestMapping(value = "/getUserList")
    @ResponseBody
    public ApiResult getUserList() {
        List<User> list = userService.getUserList();
        return ApiResultUtil.newListResult(list);
    }
}
