package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.constant.CommonConstant;
import com.qf.common.exception.BaseException;
import com.qf.common.util.ResponseCode;
import com.qf.common.util.SecurityUtils;
import com.qf.common.util.ToolUtils;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.mapper.SysUserMapper;
import com.qf.web.system.service.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 清风
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
 * @createDate 2024-01-14 11:23:53
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
        implements SysUserService {

    @Resource
    SysUserMapper sysUserMapper;

    @Resource
    SysRoleService sysRoleService;

    @Resource
    SysUserRoleService userRoleService;

    @Resource
    SysPermissionService sysPermissionService;

    /**
     * @param username 用户名
     * @return com.qf.web.system.domain.entity.SysUser
     * @description 根据用户名查询用户信息
     */
    @Override
    public SysUser selectByUsername(String username) {
        SysUser user = sysUserMapper.selectByUsername(username);
        // 通过id获取权限和角色
        if (user != null) {
            List<String> roles = sysRoleService.selectRoleByUserId(user.getId());
            List<String> perms = sysPermissionService.selectPermsByUserId(user.getId());
            user.setRoles(roles);
            user.setPerms(perms);
        }
        return user;
    }

    /**
     * @author: sin
     * @Description 插入用户表
     */
    private int addUser(SysUser user) {
        if (!ToolUtils.isOk(sysUserMapper.insert(user))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.ADD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @author: sin
     * @Description 更新用户表信息
     */
    private int updateUser(Long userId, UserForm userForm) {
        if (!ToolUtils.isOk(sysUserMapper.updateUserById(userId, userForm.getNickname(), userForm.getGender(), userForm.getAvatar(), userForm.getMobile(), userForm.getEmail(), userForm.getStatus()))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.EDIT + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @return com.qf.web.system.domain.vo.UserInfoVo
     * @description 获取当前登录用户信息
     */
    @Override
    public UserInfoVo getUserInfo() {
        SysUser userInfo = SecurityUtils.getUserInfo();

        if (userInfo != null) {
            UserInfoVo user = new UserInfoVo(userInfo.getId(),
                    userInfo.getUsername(),
                    userInfo.getNickname(),
                    userInfo.getGender(),
                    userInfo.getAvatar(),
                    userInfo.getEmail(),
                    userInfo.getMobile(),
                    userInfo.getContent(),
                    userInfo.getCreateTime(),
                    userInfo.getRoles(),
                    userInfo.getPerms());
            return user;
        }
        return null;
    }

    /**
     * @param userForm 新增用户表单
     * @description 新增用户
     */
    @Override
    @Transactional
    public int addUser(UserForm userForm) {
        try {
            SysUser user = new SysUser(null, userForm.getUsername(), userForm.getNickname(), userForm.getGender(), CommonConstant.PASSWORD, userForm.getAvatar(), userForm.getMobile(), userForm.getStatus(), userForm.getEmail(), 0, "");
            addUser(user);
            // 新增用户角色信息
            userRoleService.insert(user.getId(), userForm.getRoleIds().get(0));
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.ADD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @param userForm 用户信息表单
     * @description 根据用户id更新用户信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateByUserId(Long userId, UserForm userForm) {
        try {
            updateUser(userId, userForm);
            // 更新用户角色信息
            userRoleService.updateRoleByUserId(userId, userForm.getRoleIds().get(0));
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.EDIT + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }
}
