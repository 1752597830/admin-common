package com.qf.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.utils.SecurityUtils;
import com.qf.web.domain.dto.UserPage;
import com.qf.web.domain.entity.SysUser;
import com.qf.web.domain.vo.UserForm;
import com.qf.web.domain.vo.UserPageVo;
import com.qf.web.domain.vo.UserVo;
import com.qf.web.service.SysPermissionService;
import com.qf.web.service.SysRoleService;
import com.qf.web.service.SysUserService;
import com.qf.web.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2023-12-13 10:00:36
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysRoleService  sysRoleService;

    @Resource
    SysPermissionService sysPermissionService;

    @Override
    public SysUser selectByUsername(String username) {

        SysUser user = sysUserMapper.selectByUsername(username);
        // 通过id获取权限和角色
        if (user!= null) {
            List<String> roles = sysRoleService.selectRoleByUserId(user.getId());
            List<String> perms = sysPermissionService.selectPermsByUserId(user.getId());
            user.setRoles(roles);
            user.setPerms(perms);
        }
        return user;
    }

    @Override
    public UserVo getUserInfo() {
        SysUser userInfo = SecurityUtils.getUserInfo();
        UserVo userVo = new UserVo();
        if (userInfo!= null) {
            userVo.setUserId(userInfo.getId());
            userVo.setNickname(userInfo.getNickname());
            userVo.setAvatar(userInfo.getAvatar());
            userVo.setMobile(userInfo.getMobile());
            userVo.setGender(userInfo.getGender());
            userVo.setEmail(userInfo.getEmail());
            userVo.setCreateTime(userInfo.getCreateTime());
            userVo.setRoles(userInfo.getRoles());
            userVo.setPerms(userInfo.getPerms());
        }
        return userVo;
    }

    @Override
    public List<UserPageVo> getPage(UserPage userPage) {
        List<UserPageVo> userPageVoList = new ArrayList<>();
        if (userPage!= null) {
            userPageVoList = sysUserMapper.getPage(userPage.getKeywords(), userPage.getStatus() != null? userPage.getStatus().toString() : null, userPage.getStartTime(), userPage.getEndTime());
            userPageVoList.forEach(userPageVo -> {
                userPageVo.setGender(userPageVo.getGender().equals("1") ? "男" : "女");
            });
        }
        return userPageVoList;
    }

    @Override
    public UserForm getUserFormByUid(Long userId) {
        UserForm userForm = sysUserMapper.getUserFormByUid(userId);
        if (userForm!= null) {
            List<Long> rolesId = sysRoleService.selectRoleIdByUserId(userId);
            userForm.setRoleIds(rolesId);
        }
        return userForm;
    }

    @Override
    public Integer save(UserForm userForm) {
        String username = userForm.getUsername();
        String nickname = userForm.getNickname();
        String mobile = userForm.getMobile();
        Integer gender = userForm.getGender();
        String email = userForm.getEmail();
        Integer status = userForm.getStatus();
        SysUser user = new SysUser(null,username, nickname, gender, "123456", mobile, status, email);
        return sysUserMapper.insert(user);
    }

    @Override
    public int deleteBatchIds(String ids) {
        if (ids == null || "".equals(ids.trim())) {
            return 0;
        }
        String[] split = ids.split(",");
        List<String> list = Arrays.stream(split).toList();
        return sysUserMapper.deleteBatchIds(list);
    }

    @Override
    public int updateByUserId(UserForm userForm) {
        String username = userForm.getUsername();
        String nickname = userForm.getNickname();
        String mobile = userForm.getMobile();
        Integer gender = userForm.getGender();
        String email = userForm.getEmail();
        Integer status = userForm.getStatus();
        SysUser user = new SysUser(userForm.getId(),username, nickname, gender, "123456", mobile, status, email);
        return sysUserMapper.updateById(user);
    }
}




