package com.example.docker.composes.demo.mall.service;

import com.example.docker.composes.demo.mall.entity.UmsAdmin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.docker.composes.demo.mall.entity.UmsPermission;

import java.util.List;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author qy
 * @since 2020-08-04
 */
public interface IUmsAdminService extends IService<UmsAdmin> {

    UmsAdmin getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Long id);


    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);
}
