package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.constant.CommonConstant;
import com.qf.common.exception.BaseException;
import com.qf.common.enmu.ResponseCode;
import com.qf.common.util.SecurityUtils;
import com.qf.common.util.SingletonRegistry;
import com.qf.common.util.ToolUtils;
import com.qf.web.system.domain.dto.UserSearchDto;
import com.qf.web.system.domain.entity.SysUser;
import com.qf.web.system.domain.form.PwdForm;
import com.qf.web.system.domain.form.UserForm;
import com.qf.web.system.domain.vo.UserInfoVo;
import com.qf.web.system.domain.vo.UserPageVo;
import com.qf.web.system.mapper.SysUserMapper;
import com.qf.web.system.service.SysPermissionService;
import com.qf.web.system.service.SysRoleService;
import com.qf.web.system.service.SysUserRoleService;
import com.qf.web.system.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
     * @param userId 用户id
     * @return UserForm
     * @description 根据用户id查询用户信息
     */
    @Override
    public UserForm getUserFormByUid(Long userId) {
        UserForm userForm = sysUserMapper.getUserFormByUid(userId);
        if (userForm != null) {
            List<Long> rolesId = userRoleService.selectRoleIdByUserId(userId);
            userForm.setRoleIds(rolesId);
        } else {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.SELECT + CommonConstant.USER + CommonConstant.ERROR);
        }
        return userForm;
    }

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

    /**
     * @author: sin
     * @Description 逻辑删除用户 修改is_deleted字段值为1
     */
    @Override
    @Transactional
    public int deleteByUserId(String ids) {
        try {
            List<Long> userIds = Arrays.stream(ids.split(",")).map(Long::valueOf).collect(Collectors.toList());
            deleteByUserId(userIds);
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.DELETE + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @author: sin
     * @Description 重置用户密码
     */
    @Override
    @Transactional
    public int resetPasswordByUserId(Long userId) {
        try {
            resetPassword(userId, CommonConstant.PASSWORD);
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.RESET_PASSWORD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @param userSearch 用户搜索条件
     * @return java.util.List<com.qf.web.system.domain.vo.UserPageVo>
     * @description 获取分页用户
     */
    @Override
    public List<UserPageVo> getUserPage(UserSearchDto userSearch) {
        try {
            return sysUserMapper.queryUser(userSearch.getUsername(), userSearch.getPhone(), userSearch.getStatus());
        } catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.SELECT + CommonConstant.USER + CommonConstant.ERROR);
        }
    }

    @Override
    @Transactional
    public int changePassword(PwdForm pwdForm) {
        SysUser userInfo = SecurityUtils.getUserInfo();
        SingletonRegistry registry = SingletonRegistry.getInstance();
        BCryptPasswordEncoder encoder = registry.getPasswordEncoder();
        boolean matches = encoder.matches(pwdForm.getOldPassword(), userInfo.getPassword());
        if (!matches) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.OLD_PASSWORD + CommonConstant.ERROR);
        }
        try {
            resetPassword(userInfo.getId(), pwdForm.getConfirmPassword());
            userInfo.setPassword(pwdForm.getConfirmPassword());
            // TODO 更新redis中保存的Authoritarian信息
        }catch (Exception e) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.EDIT_PASSWORD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
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
     * @param userIds 用户id集合
     * @description 根据用户id集合删除用户
     */
    private int deleteByUserId(List<Long> userIds) {
        if (!ToolUtils.isOk(sysUserMapper.deleteByUserId(userIds))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.DELETE + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @author: sin
     * @Description 根据id重置密码
     */
    private int resetPassword(Long userId, String password) {
        if (!ToolUtils.isOk(sysUserMapper.resetPassword(userId, password))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.RESET_PASSWORD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }
}