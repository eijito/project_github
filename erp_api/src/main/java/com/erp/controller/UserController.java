package com.erp.controller;

import com.erp.entity.SysUser;
import com.erp.service.UserService;
import com.erp.util.ErpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 * @version 1.0.0
 * @description 未定义
 * @date 2017/12/14 17:58
 * @Email eijito@foxmail.com
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    public ErpResult login(SysUser user, String checkCode, HttpServletRequest request){
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if(!code.equalsIgnoreCase(checkCode)){
               return ErpResult.build(202,"verification code error");
        }
        ErpResult erpResult = userService.doLogin(user);
        return erpResult;
    }
}
