package com.erp.controller;

import com.erp.entity.SysUser;
import com.erp.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0.0
 * @description 测试controller
 * @date 2017/12/13 21:01
 * @Email eijito@foxmail.com
 */

@Controller
@RequestMapping("/api")
public class TestController {

    @Autowired
    SysUserMapper sysUserMapper;

    @RequestMapping("/testmysql")
    @ResponseBody
    public List<SysUser> test01(){
        List<SysUser> allUser = sysUserMapper.getAllUser();
        return allUser;
    }
 }
