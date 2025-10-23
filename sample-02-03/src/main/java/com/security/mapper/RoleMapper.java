package com.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.model.po.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
