package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.PmsSkuStock;
import com.example.docker.composes.demo.mall.mapper.PmsSkuStockMapper;
import com.example.docker.composes.demo.mall.service.IPmsSkuStockService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sku的库存 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-05
 */
@Service
public class PmsSkuStockServiceImpl extends ServiceImpl<PmsSkuStockMapper, PmsSkuStock> implements IPmsSkuStockService {

}
