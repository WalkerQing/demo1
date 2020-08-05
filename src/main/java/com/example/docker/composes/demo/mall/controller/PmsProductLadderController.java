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


import com.example.docker.composes.demo.mall.entity.PmsProductLadder;
import com.example.docker.composes.demo.mall.service.IPmsProductLadderService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品阶梯价格表(只针对同商品) 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-ladder")
public class PmsProductLadderController {
    @Autowired
    IPmsProductLadderService pmsProductLadderService;

    @ApiOperation("get PmsProductLadder")
    @GetMapping("getPmsProductLadder")
    public CommonResult getPmsProductLadder(Long id){
        CommonResult<PmsProductLadder> commonResult;
        PmsProductLadder pmsProductLadder = pmsProductLadderService.getById(id);
        commonResult = pmsProductLadder == null ? CommonResult.failed() : CommonResult.success(pmsProductLadder);
        return commonResult;
    }



    @ApiOperation("PmsProductLadder list")
    @GetMapping("listPmsProductLadder")
    public CommonResult listPmsProductLadder(){
        CommonResult<List<PmsProductLadder>> commonResult;
        List<PmsProductLadder> pmsProductLadders = pmsProductLadderService.list();
        commonResult = pmsProductLadders == null ? CommonResult.failed() : CommonResult.success(pmsProductLadders);
        return commonResult;
    }


    @ApiOperation("save PmsProductLadder")
    @PostMapping("save")
    public CommonResult savePmsProductLadder(PmsProductLadder pmsProductLadder){
        CommonResult<String> commonResult;
        boolean result = pmsProductLadderService.save(pmsProductLadder);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductLadder")
    @PostMapping("update")
    public CommonResult updatePmsProductLadder(PmsProductLadder pmsProductLadder){
        CommonResult<String> commonResult;
        boolean result = pmsProductLadderService.updateById(pmsProductLadder);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductLadder")
    @PostMapping("delete")
    public CommonResult deletePmsProductLadder(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductLadderService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductLadder list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductLadder> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductLadder> resultPage = pmsProductLadderService.page(page);
        return CommonResult.success(resultPage);
    }


}

