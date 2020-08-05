package com.example.docker.composes.demo.mall.service.impl;

import com.example.docker.composes.demo.mall.entity.PmsProductCategoryAttributeRelation;
import com.example.docker.composes.demo.mall.mapper.PmsProductCategoryAttributeRelationMapper;
import com.example.docker.composes.demo.mall.service.IPmsProductCategoryAttributeRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 服务实现类
 * </p>
 *
 * @author qy
 * @since 2020-08-05
 */
@Service
public class PmsProductCategoryAttributeRelationServiceImpl extends ServiceImpl<PmsProductCategoryAttributeRelationMapper, PmsProductCategoryAttributeRelation> implements IPmsProductCategoryAttributeRelationService {

}
