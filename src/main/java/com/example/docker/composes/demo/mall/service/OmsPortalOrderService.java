package com.example.docker.composes.demo.mall.service;

import com.example.docker.composes.demo.mall.common.api.CommonResult;
import com.example.docker.composes.demo.mall.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

public interface OmsPortalOrderService {
    /**
     * 根据提交信息生成订单
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);

    /**
     * 取消单个超时订单
     */
    @Transactional
    void cancelOrder(Long orderId);
}