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


import com.example.docker.composes.demo.mall.entity.PmsProductAttribute;
import com.example.docker.composes.demo.mall.service.IPmsProductAttributeService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 商品属性参数表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-attribute")
public class PmsProductAttributeController {
    @Autowired
    IPmsProductAttributeService pmsProductAttributeService;

    @ApiOperation("get PmsProductAttribute")
    @GetMapping("getPmsProductAttribute")
    public CommonResult getPmsProductAttribute(Long id){
        CommonResult<PmsProductAttribute> commonResult;
        PmsProductAttribute pmsProductAttribute = pmsProductAttributeService.getById(id);
        commonResult = pmsProductAttribute == null ? CommonResult.failed() : CommonResult.success(pmsProductAttribute);
        return commonResult;
    }



    @ApiOperation("PmsProductAttribute list")
    @GetMapping("listPmsProductAttribute")
    public CommonResult listPmsProductAttribute(){
        CommonResult<List<PmsProductAttribute>> commonResult;
        List<PmsProductAttribute> pmsProductAttributes = pmsProductAttributeService.list();
        commonResult = pmsProductAttributes == null ? CommonResult.failed() : CommonResult.success(pmsProductAttributes);
        return commonResult;
    }


    @ApiOperation("save PmsProductAttribute")
    @PostMapping("save")
    public CommonResult savePmsProductAttribute(PmsProductAttribute pmsProductAttribute){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeService.save(pmsProductAttribute);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductAttribute")
    @PostMapping("update")
    public CommonResult updatePmsProductAttribute(PmsProductAttribute pmsProductAttribute){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeService.updateById(pmsProductAttribute);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductAttribute")
    @PostMapping("delete")
    public CommonResult deletePmsProductAttribute(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductAttribute list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductAttribute> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductAttribute> resultPage = pmsProductAttributeService.page(page);
        return CommonResult.success(resultPage);
    }


}

