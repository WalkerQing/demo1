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


import com.example.docker.composes.demo.mall.entity.PmsProductFullReduction;
import com.example.docker.composes.demo.mall.service.IPmsProductFullReductionService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品满减表(只针对同商品) 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-full-reduction")
public class PmsProductFullReductionController {
    @Autowired
    IPmsProductFullReductionService pmsProductFullReductionService;

    @ApiOperation("get PmsProductFullReduction")
    @GetMapping("getPmsProductFullReduction")
    public CommonResult getPmsProductFullReduction(Long id){
        CommonResult<PmsProductFullReduction> commonResult;
        PmsProductFullReduction pmsProductFullReduction = pmsProductFullReductionService.getById(id);
        commonResult = pmsProductFullReduction == null ? CommonResult.failed() : CommonResult.success(pmsProductFullReduction);
        return commonResult;
    }



    @ApiOperation("PmsProductFullReduction list")
    @GetMapping("listPmsProductFullReduction")
    public CommonResult listPmsProductFullReduction(){
        CommonResult<List<PmsProductFullReduction>> commonResult;
        List<PmsProductFullReduction> pmsProductFullReductions = pmsProductFullReductionService.list();
        commonResult = pmsProductFullReductions == null ? CommonResult.failed() : CommonResult.success(pmsProductFullReductions);
        return commonResult;
    }


    @ApiOperation("save PmsProductFullReduction")
    @PostMapping("save")
    public CommonResult savePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){
        CommonResult<String> commonResult;
        boolean result = pmsProductFullReductionService.save(pmsProductFullReduction);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductFullReduction")
    @PostMapping("update")
    public CommonResult updatePmsProductFullReduction(PmsProductFullReduction pmsProductFullReduction){
        CommonResult<String> commonResult;
        boolean result = pmsProductFullReductionService.updateById(pmsProductFullReduction);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductFullReduction")
    @PostMapping("delete")
    public CommonResult deletePmsProductFullReduction(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductFullReductionService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductFullReduction list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductFullReduction> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductFullReduction> resultPage = pmsProductFullReductionService.page(page);
        return CommonResult.success(resultPage);
    }


}

