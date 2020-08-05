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


import com.example.docker.composes.demo.mall.entity.PmsProduct;
import com.example.docker.composes.demo.mall.service.IPmsProductService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 商品信息 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product")
public class PmsProductController {
    @Autowired
    IPmsProductService pmsProductService;

    @ApiOperation("get PmsProduct")
    @GetMapping("getPmsProduct")
    public CommonResult getPmsProduct(Long id){
        CommonResult<PmsProduct> commonResult;
        PmsProduct pmsProduct = pmsProductService.getById(id);
        commonResult = pmsProduct == null ? CommonResult.failed() : CommonResult.success(pmsProduct);
        return commonResult;
    }



    @ApiOperation("PmsProduct list")
    @GetMapping("listPmsProduct")
    public CommonResult listPmsProduct(){
        CommonResult<List<PmsProduct>> commonResult;
        List<PmsProduct> pmsProducts = pmsProductService.list();
        commonResult = pmsProducts == null ? CommonResult.failed() : CommonResult.success(pmsProducts);
        return commonResult;
    }


    @ApiOperation("save PmsProduct")
    @PostMapping("save")
    public CommonResult savePmsProduct(PmsProduct pmsProduct){
        CommonResult<String> commonResult;
        boolean result = pmsProductService.save(pmsProduct);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProduct")
    @PostMapping("update")
    public CommonResult updatePmsProduct(PmsProduct pmsProduct){
        CommonResult<String> commonResult;
        boolean result = pmsProductService.updateById(pmsProduct);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProduct")
    @PostMapping("delete")
    public CommonResult deletePmsProduct(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProduct list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProduct> page = new Page<>(pageNum,pageSize);
        return CommonResult.success(pmsProductService.page(page,null));
    }


}

