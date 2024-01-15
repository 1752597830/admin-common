package com.qf.web.system.mapper;

import com.qf.web.system.domain.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2024-01-14 11:23:53
* @Entity com.qf.web.system.domain.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    @Select("select id,username,nickname,gender,password,avatar,mobile,status,email,is_deleted,content from sys_user where username = #{username}")
    SysUser selectByUsername(String username);

    int updateUserById(Long userId, String nickname, Integer gender, String avatar, String mobile, String email,Integer status);
}




