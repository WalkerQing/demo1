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


import com.example.docker.composes.demo.mall.entity.PmsProductAttributeValue;
import com.example.docker.composes.demo.mall.service.IPmsProductAttributeValueService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 存储产品参数信息的表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-attribute-value")
public class PmsProductAttributeValueController {
    @Autowired
    IPmsProductAttributeValueService pmsProductAttributeValueService;

    @ApiOperation("get PmsProductAttributeValue")
    @GetMapping("getPmsProductAttributeValue")
    public CommonResult getPmsProductAttributeValue(Long id){
        CommonResult<PmsProductAttributeValue> commonResult;
        PmsProductAttributeValue pmsProductAttributeValue = pmsProductAttributeValueService.getById(id);
        commonResult = pmsProductAttributeValue == null ? CommonResult.failed() : CommonResult.success(pmsProductAttributeValue);
        return commonResult;
    }



    @ApiOperation("PmsProductAttributeValue list")
    @GetMapping("listPmsProductAttributeValue")
    public CommonResult listPmsProductAttributeValue(){
        CommonResult<List<PmsProductAttributeValue>> commonResult;
        List<PmsProductAttributeValue> pmsProductAttributeValues = pmsProductAttributeValueService.list();
        commonResult = pmsProductAttributeValues == null ? CommonResult.failed() : CommonResult.success(pmsProductAttributeValues);
        return commonResult;
    }


    @ApiOperation("save PmsProductAttributeValue")
    @PostMapping("save")
    public CommonResult savePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeValueService.save(pmsProductAttributeValue);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductAttributeValue")
    @PostMapping("update")
    public CommonResult updatePmsProductAttributeValue(PmsProductAttributeValue pmsProductAttributeValue){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeValueService.updateById(pmsProductAttributeValue);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductAttributeValue")
    @PostMapping("delete")
    public CommonResult deletePmsProductAttributeValue(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductAttributeValueService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductAttributeValue list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductAttributeValue> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductAttributeValue> resultPage = pmsProductAttributeValueService.page(page);
        return CommonResult.success(resultPage);
    }


}

