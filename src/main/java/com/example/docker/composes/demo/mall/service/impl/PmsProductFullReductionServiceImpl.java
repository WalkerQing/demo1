package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.PmsProductFullReduction;
import com.example.docker.composes.demo.mall.mapper.PmsProductFullReductionMapper;
import com.example.docker.composes.demo.mall.service.IPmsProductFullReductionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品满减表(只针对同商品) 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-05
 */
@Service
public class PmsProductFullReductionServiceImpl extends ServiceImpl<PmsProductFullReductionMapper, PmsProductFullReduction> implements IPmsProductFullReductionService {

}
