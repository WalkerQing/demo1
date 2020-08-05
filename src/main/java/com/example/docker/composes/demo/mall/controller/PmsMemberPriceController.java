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


import com.example.docker.composes.demo.mall.entity.PmsMemberPrice;
import com.example.docker.composes.demo.mall.service.IPmsMemberPriceService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 商品会员价格表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-member-price")
public class PmsMemberPriceController {
    @Autowired
    IPmsMemberPriceService pmsMemberPriceService;

    @ApiOperation("get PmsMemberPrice")
    @GetMapping("getPmsMemberPrice")
    public CommonResult getPmsMemberPrice(Long id){
        CommonResult<PmsMemberPrice> commonResult;
        PmsMemberPrice pmsMemberPrice = pmsMemberPriceService.getById(id);
        commonResult = pmsMemberPrice == null ? CommonResult.failed() : CommonResult.success(pmsMemberPrice);
        return commonResult;
    }



    @ApiOperation("PmsMemberPrice list")
    @GetMapping("listPmsMemberPrice")
    public CommonResult listPmsMemberPrice(){
        CommonResult<List<PmsMemberPrice>> commonResult;
        List<PmsMemberPrice> pmsMemberPrices = pmsMemberPriceService.list();
        commonResult = pmsMemberPrices == null ? CommonResult.failed() : CommonResult.success(pmsMemberPrices);
        return commonResult;
    }


    @ApiOperation("save PmsMemberPrice")
    @PostMapping("save")
    public CommonResult savePmsMemberPrice(PmsMemberPrice pmsMemberPrice){
        CommonResult<String> commonResult;
        boolean result = pmsMemberPriceService.save(pmsMemberPrice);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsMemberPrice")
    @PostMapping("update")
    public CommonResult updatePmsMemberPrice(PmsMemberPrice pmsMemberPrice){
        CommonResult<String> commonResult;
        boolean result = pmsMemberPriceService.updateById(pmsMemberPrice);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsMemberPrice")
    @PostMapping("delete")
    public CommonResult deletePmsMemberPrice(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsMemberPriceService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsMemberPrice list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsMemberPrice> page = new Page<>(pageNum,pageSize);
        IPage<PmsMemberPrice> resultPage = pmsMemberPriceService.page(page);
        return CommonResult.success(resultPage);
    }


}

