package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.docker.composes.demo.mall.common.api.CommonPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.PmsProductCategoryAttributeRelation;
import com.example.docker.composes.demo.mall.service.IPmsProductCategoryAttributeRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品的分类和属性的关系表，用于设置分类筛选条件（只支持一级分类） 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-category-attribute-relation")
public class PmsProductCategoryAttributeRelationController {
    @Autowired
    IPmsProductCategoryAttributeRelationService pmsProductCategoryAttributeRelationService;

    @ApiOperation("get PmsProductCategoryAttributeRelation")
    @GetMapping("getPmsProductCategoryAttributeRelation")
    public CommonResult getPmsProductCategoryAttributeRelation(Long id){
        CommonResult<PmsProductCategoryAttributeRelation> commonResult;
        PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation = pmsProductCategoryAttributeRelationService.getById(id);
        commonResult = pmsProductCategoryAttributeRelation == null ? CommonResult.failed() : CommonResult.success(pmsProductCategoryAttributeRelation);
        return commonResult;
    }



    @ApiOperation("PmsProductCategoryAttributeRelation list")
    @GetMapping("listPmsProductCategoryAttributeRelation")
    public CommonResult listPmsProductCategoryAttributeRelation(){
        CommonResult<List<PmsProductCategoryAttributeRelation>> commonResult;
        List<PmsProductCategoryAttributeRelation> pmsProductCategoryAttributeRelations = pmsProductCategoryAttributeRelationService.list();
        commonResult = pmsProductCategoryAttributeRelations == null ? CommonResult.failed() : CommonResult.success(pmsProductCategoryAttributeRelations);
        return commonResult;
    }


    @ApiOperation("save PmsProductCategoryAttributeRelation")
    @PostMapping("save")
    public CommonResult savePmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryAttributeRelationService.save(pmsProductCategoryAttributeRelation);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductCategoryAttributeRelation")
    @PostMapping("update")
    public CommonResult updatePmsProductCategoryAttributeRelation(PmsProductCategoryAttributeRelation pmsProductCategoryAttributeRelation){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryAttributeRelationService.updateById(pmsProductCategoryAttributeRelation);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductCategoryAttributeRelation")
    @PostMapping("delete")
    public CommonResult deletePmsProductCategoryAttributeRelation(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryAttributeRelationService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductCategoryAttributeRelation list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductCategoryAttributeRelation> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductCategoryAttributeRelation> resultPage = pmsProductCategoryAttributeRelationService.page(page);
        return CommonResult.success(resultPage);
    }


}

