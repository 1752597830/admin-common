package com.qf.web.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.system.domain.dto.UserSearchDto;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.form.PwdForm;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.domain.vo.UserPageVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2024-01-14 11:23:53
*/
public interface SysUserService extends IService<SysUser> {

    UserForm getUserFormByUid(Long userId);

    SysUser selectByUsername(String username);

    UserInfoVo getUserInfo();

    int addUser(UserForm userForm);

    int updateByUserId(Long userId,UserForm userForm);

    int deleteByUserId(String userIds);

    int resetPasswordByUserId(Long userId);

    List<UserPageVo> getUserPage(UserSearchDto userSearch);

    int changePassword(PwdForm pwdForm);

}
