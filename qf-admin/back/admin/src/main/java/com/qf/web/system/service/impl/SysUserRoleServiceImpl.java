package com.qf.web.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.common.constant.CommonConstant;
import com.qf.common.exception.BaseException;
import com.qf.common.enmu.ResponseCode;
import com.qf.common.util.ToolUtils;
import com.qf.web.system.domain.entity.SysUserRole;
import com.qf.web.system.mapper.SysUserRoleMapper;
import com.qf.web.system.service.SysUserRoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service实现
* @createDate 2024-01-14 15:48:48
*/
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

    @Resource
    SysUserRoleMapper userRoleMapper;

    /**
     * @author: sin
     * @Description  插入角色用户关联信息
     * @param userId
     * @param roleId
     * @return
     */
    @Override
    public int insert(Long userId, Long roleId) {
        if(!ToolUtils.isOk(userRoleMapper.addRoleByUserId(userId,roleId))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.ADD + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @author: sin
     * @Description 更新用户角色表信息
     * @param userId
     * @param roleId
     * @return
     */
    public int updateRoleByUserId(Long userId, Long roleId) {
        if(!ToolUtils.isOk(userRoleMapper.updateRoleByUserId(userId,roleId))) {
            throw new BaseException(ResponseCode.OPT_ERROR.getCode(), CommonConstant.EDIT + CommonConstant.USER + CommonConstant.ERROR);
        }
        return 1;
    }

    /**
     * @author: sin
     * @Description 根据用户ID获取角色ID列表
     */
    @Override
    public List<Long> selectRoleIdByUserId(Long userId) {
        return userRoleMapper.selectRoleIdByUserId(userId);
    }
}




