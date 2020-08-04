package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.UmsAdminPermissionRelation;
import com.example.docker.composes.demo.mall.mapper.UmsAdminPermissionRelationMapper;
import com.example.docker.composes.demo.mall.service.IUmsAdminPermissionRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-04
 */
@Service
public class UmsAdminPermissionRelationServiceImpl extends ServiceImpl<UmsAdminPermissionRelationMapper, UmsAdminPermissionRelation> implements IUmsAdminPermissionRelationService {

}