package com.qf.web.service;

import com.qf.web.domain.dto.UserPage;
import com.qf.web.domain.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.web.domain.vo.UserForm;
import com.qf.web.domain.vo.UserPageVo;
import com.qf.web.domain.vo.UserVo;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Service
* @createDate 2023-12-13 10:00:36
*/
public interface SysUserService extends IService<SysUser> {

    SysUser selectByUsername(String username);

    UserVo getUserInfo();

    List<UserPageVo> getPage(UserPage userPage);

    UserForm getUserFormByUid(Long userId);

    Integer save(UserForm userForm);

    int deleteBatchIds(String ids);

    int updateByUserId(UserForm userForm);
}
