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


import com.example.docker.composes.demo.mall.entity.PmsProductCategory;
import com.example.docker.composes.demo.mall.service.IPmsProductCategoryService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品分类 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-category")
public class PmsProductCategoryController {
    @Autowired
    IPmsProductCategoryService pmsProductCategoryService;

    @ApiOperation("get PmsProductCategory")
    @GetMapping("getPmsProductCategory")
    public CommonResult getPmsProductCategory(Long id){
        CommonResult<PmsProductCategory> commonResult;
        PmsProductCategory pmsProductCategory = pmsProductCategoryService.getById(id);
        commonResult = pmsProductCategory == null ? CommonResult.failed() : CommonResult.success(pmsProductCategory);
        return commonResult;
    }



    @ApiOperation("PmsProductCategory list")
    @GetMapping("listPmsProductCategory")
    public CommonResult listPmsProductCategory(){
        CommonResult<List<PmsProductCategory>> commonResult;
        List<PmsProductCategory> pmsProductCategorys = pmsProductCategoryService.list();
        commonResult = pmsProductCategorys == null ? CommonResult.failed() : CommonResult.success(pmsProductCategorys);
        return commonResult;
    }


    @ApiOperation("save PmsProductCategory")
    @PostMapping("save")
    public CommonResult savePmsProductCategory(PmsProductCategory pmsProductCategory){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryService.save(pmsProductCategory);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductCategory")
    @PostMapping("update")
    public CommonResult updatePmsProductCategory(PmsProductCategory pmsProductCategory){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryService.updateById(pmsProductCategory);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductCategory")
    @PostMapping("delete")
    public CommonResult deletePmsProductCategory(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductCategoryService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductCategory list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductCategory> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductCategory> resultPage = pmsProductCategoryService.page(page);
        return CommonResult.success(resultPage);
    }


}

