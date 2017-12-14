package com.erp.mapper;


import com.erp.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
    List<SysUser>  getAllUser();

    SysUser dologin(@Param("username") String username, @Param("pwd")String pwd);
}