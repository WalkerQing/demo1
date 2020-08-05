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


import com.example.docker.composes.demo.mall.entity.PmsProductAttributeCategory;
import com.example.docker.composes.demo.mall.service.IPmsProductAttributeCategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品属性分类表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-attribute-category")
public class PmsProductAttributeCategoryController {
    @Autowired
    IPmsProductAttributeCategoryService pmsProductAttributeCategoryService;

    @ApiOperation("get PmsProductAttributeCategory")
    @GetMapping("getPmsProductAttributeCategory")
    public CommonResult getPmsProductAttributeCategory(Long id){
        CommonResult<PmsProductAttributeCategory> commonResult;
        PmsProductAttributeCategory pmsProductAttributeCategory = pmsProductAttributeCategoryService.getById(id);
        commonResult = pmsProductAttributeCategory == null ? CommonResult.failed() : CommonResult.success(pmsProductAttributeCategory);
        return commonResult;
    }



    @ApiOperation("PmsProductAttributeCategory list")
    @GetMapping("listPmsProductAttributeCategory")
    public CommonResult listPmsProductAttributeCategory(){
        CommonResult<List<PmsProductAttributeCategory>> commonResult;
        List<PmsProductAttributeCategory> pmsProductAttributeCategorys = pmsProductAttributeCategoryService.list();
        commonResult = pmsProductAttributeCategorys == null ? CommonResult.failed() : CommonResult.success(pmsProductAttributeCategorys);
        return commonResult;
    }


    @ApiOperation("save PmsProductAttributeCategory")
    @PostMapping("save")
    public CommonResult savePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeCategoryService.save(pmsProductAttributeCategory);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductAttributeCategory")
    @PostMapping("update")
    public CommonResult updatePmsProductAttributeCategory(PmsProductAttributeCategory pmsProductAttributeCategory){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeCategoryService.updateById(pmsProductAttributeCategory);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductAttributeCategory")
    @PostMapping("delete")
    public CommonResult deletePmsProductAttributeCategory(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeCategoryService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductAttributeCategory list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductAttributeCategory> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductAttributeCategory> resultPage = pmsProductAttributeCategoryService.page(page);
        return CommonResult.success(resultPage);
    }


}

