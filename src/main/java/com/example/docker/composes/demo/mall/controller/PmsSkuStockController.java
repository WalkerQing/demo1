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


import com.example.docker.composes.demo.mall.entity.PmsSkuStock;
import com.example.docker.composes.demo.mall.service.IPmsSkuStockService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * sku的库存 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-sku-stock")
public class PmsSkuStockController {
    @Autowired
    IPmsSkuStockService pmsSkuStockService;

    @ApiOperation("get PmsSkuStock")
    @GetMapping("getPmsSkuStock")
    public CommonResult getPmsSkuStock(Long id){
        CommonResult<PmsSkuStock> commonResult;
        PmsSkuStock pmsSkuStock = pmsSkuStockService.getById(id);
        commonResult = pmsSkuStock == null ? CommonResult.failed() : CommonResult.success(pmsSkuStock);
        return commonResult;
    }



    @ApiOperation("PmsSkuStock list")
    @GetMapping("listPmsSkuStock")
    public CommonResult listPmsSkuStock(){
        CommonResult<List<PmsSkuStock>> commonResult;
        List<PmsSkuStock> pmsSkuStocks = pmsSkuStockService.list();
        commonResult = pmsSkuStocks == null ? CommonResult.failed() : CommonResult.success(pmsSkuStocks);
        return commonResult;
    }


    @ApiOperation("save PmsSkuStock")
    @PostMapping("save")
    public CommonResult savePmsSkuStock(PmsSkuStock pmsSkuStock){
        CommonResult<String> commonResult;
        boolean result = pmsSkuStockService.save(pmsSkuStock);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsSkuStock")
    @PostMapping("update")
    public CommonResult updatePmsSkuStock(PmsSkuStock pmsSkuStock){
        CommonResult<String> commonResult;
        boolean result = pmsSkuStockService.updateById(pmsSkuStock);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsSkuStock")
    @PostMapping("delete")
    public CommonResult deletePmsSkuStock(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsSkuStockService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsSkuStock list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsSkuStock> page = new Page<>(pageNum,pageSize);
        IPage<PmsSkuStock> resultPage = pmsSkuStockService.page(page);
        return CommonResult.success(resultPage);
    }


}

