package com.erp.service.impl;

import com.erp.entity.SysUser;
import com.erp.mapper.SysUserMapper;
import com.erp.service.UserService;
import com.erp.util.ErpResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @version 1.0.0
 * @description 未定义
 * @date 2017/12/14 18:08
 * @Email eijito@foxmail.com
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public ErpResult doLogin(SysUser user) {
        /**
         * shiro框架 md5加密 1.source 原密码 2.salt 扰乱码 3.hashIteration 散列次数
         */
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),user.getUsername(),2);
        //pwd是加密后的字符串
        String pwd = md5Hash.toString();
        SysUser sysUser = sysUserMapper.dologin(user.getUsername(),pwd);
        if(sysUser!=null){
            return ErpResult.build(200,"login success",sysUser);
        }
        return ErpResult.build(201,"login fail");
    }
}
