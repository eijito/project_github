package com.erp.service;

import com.erp.entity.SysUser;
import com.erp.util.ErpResult;

/**
 * @author Administrator
 * @version 1.0.0
 * @description 未定义
 * @date 2017/12/14 18:03
 * @Email eijito@foxmail.com
 */
public interface UserService {
   ErpResult doLogin(SysUser user);
}
