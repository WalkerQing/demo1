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


import com.example.docker.composes.demo.mall.entity.PmsProductVertifyRecord;
import com.example.docker.composes.demo.mall.service.IPmsProductVertifyRecordService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 商品审核记录 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-vertify-record")
public class PmsProductVertifyRecordController {
    @Autowired
    IPmsProductVertifyRecordService pmsProductVertifyRecordService;

    @ApiOperation("get PmsProductVertifyRecord")
    @GetMapping("getPmsProductVertifyRecord")
    public CommonResult getPmsProductVertifyRecord(Long id){
        CommonResult<PmsProductVertifyRecord> commonResult;
        PmsProductVertifyRecord pmsProductVertifyRecord = pmsProductVertifyRecordService.getById(id);
        commonResult = pmsProductVertifyRecord == null ? CommonResult.failed() : CommonResult.success(pmsProductVertifyRecord);
        return commonResult;
    }



    @ApiOperation("PmsProductVertifyRecord list")
    @GetMapping("listPmsProductVertifyRecord")
    public CommonResult listPmsProductVertifyRecord(){
        CommonResult<List<PmsProductVertifyRecord>> commonResult;
        List<PmsProductVertifyRecord> pmsProductVertifyRecords = pmsProductVertifyRecordService.list();
        commonResult = pmsProductVertifyRecords == null ? CommonResult.failed() : CommonResult.success(pmsProductVertifyRecords);
        return commonResult;
    }


    @ApiOperation("save PmsProductVertifyRecord")
    @PostMapping("save")
    public CommonResult savePmsProductVertifyRecord(PmsProductVertifyRecord pmsProductVertifyRecord){
        CommonResult<String> commonResult;
        boolean result = pmsProductVertifyRecordService.save(pmsProductVertifyRecord);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductVertifyRecord")
    @PostMapping("update")
    public CommonResult updatePmsProductVertifyRecord(PmsProductVertifyRecord pmsProductVertifyRecord){
        CommonResult<String> commonResult;
        boolean result = pmsProductVertifyRecordService.updateById(pmsProductVertifyRecord);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductVertifyRecord")
    @PostMapping("delete")
    public CommonResult deletePmsProductVertifyRecord(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductVertifyRecordService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductVertifyRecord list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductVertifyRecord> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductVertifyRecord> resultPage = pmsProductVertifyRecordService.page(page);
        return CommonResult.success(resultPage);
    }


}

