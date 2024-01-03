package com.qf.web.mapper;

import com.qf.web.domain.dto.UserPage;
import com.qf.web.domain.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.web.domain.vo.UserForm;
import com.qf.web.domain.vo.UserPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author 清风
* @description 针对表【sys_user(用户信息表)】的数据库操作Mapper
* @createDate 2023-12-13 10:00:36
* @Entity com.qf.web.domain.entity.SysUser
*/
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<UserPageVo> getPage(String keywords, String status, String startTime, String endTime);

    UserForm getUserFormByUid(Long userId);

    @Select("select * from sys_user where username = #{username}")
    SysUser selectByUsername(String username);
}




