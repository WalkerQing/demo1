package com.example.docker.composes.demo.mall.mapper;

import com.example.docker.composes.demo.mall.entity.UmsAdminRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.docker.composes.demo.mall.entity.UmsPermission;

import java.util.List;

/**
 * <p>
 * 后台用户和角色关系表 Mapper 接口
 * </p>
 *
 * @author qy
 * @since 2020-08-04
 */
public interface UmsAdminRoleRelationMapper extends BaseMapper<UmsAdminRoleRelation> {
    public List<UmsPermission> getPermissionList(Long id);
}
