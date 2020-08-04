package com.example.docker.composes.demo.mall.service;

import com.example.docker.composes.demo.mall.common.api.CommonResult;
import com.example.docker.composes.demo.mall.entity.UmsMember;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author qy
 * @since 2020-08-04
 */
public interface IUmsMemberService extends IService<UmsMember> {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号码是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
