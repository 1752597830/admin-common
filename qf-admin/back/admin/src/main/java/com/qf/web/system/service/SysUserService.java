package com.qf.web.system.service;

import com.qf.web.system.domain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-01-14 11:23:53
*/
public interface SysUserService extends IService<SysUser> {

    SysUser selectByUsername(String username);

    UserInfoVo getUserInfo();

    void addUser(UserForm userForm);
}
