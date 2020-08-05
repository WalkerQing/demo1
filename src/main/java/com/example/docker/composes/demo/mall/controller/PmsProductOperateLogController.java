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


import com.example.docker.composes.demo.mall.entity.PmsProductOperateLog;
import com.example.docker.composes.demo.mall.service.IPmsProductOperateLogService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    *  前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-product-operate-log")
public class PmsProductOperateLogController {
    @Autowired
    IPmsProductOperateLogService pmsProductOperateLogService;

    @ApiOperation("get PmsProductOperateLog")
    @GetMapping("getPmsProductOperateLog")
    public CommonResult getPmsProductOperateLog(Long id){
        CommonResult<PmsProductOperateLog> commonResult;
        PmsProductOperateLog pmsProductOperateLog = pmsProductOperateLogService.getById(id);
        commonResult = pmsProductOperateLog == null ? CommonResult.failed() : CommonResult.success(pmsProductOperateLog);
        return commonResult;
    }



    @ApiOperation("PmsProductOperateLog list")
    @GetMapping("listPmsProductOperateLog")
    public CommonResult listPmsProductOperateLog(){
        CommonResult<List<PmsProductOperateLog>> commonResult;
        List<PmsProductOperateLog> pmsProductOperateLogs = pmsProductOperateLogService.list();
        commonResult = pmsProductOperateLogs == null ? CommonResult.failed() : CommonResult.success(pmsProductOperateLogs);
        return commonResult;
    }


    @ApiOperation("save PmsProductOperateLog")
    @PostMapping("save")
    public CommonResult savePmsProductOperateLog(PmsProductOperateLog pmsProductOperateLog){
        CommonResult<String> commonResult;
        boolean result = pmsProductOperateLogService.save(pmsProductOperateLog);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsProductOperateLog")
    @PostMapping("update")
    public CommonResult updatePmsProductOperateLog(PmsProductOperateLog pmsProductOperateLog){
        CommonResult<String> commonResult;
        boolean result = pmsProductOperateLogService.updateById(pmsProductOperateLog);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsProductOperateLog")
    @PostMapping("delete")
    public CommonResult deletePmsProductOperateLog(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsProductOperateLogService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsProductOperateLog list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsProductOperateLog> page = new Page<>(pageNum,pageSize);
        IPage<PmsProductOperateLog> resultPage = pmsProductOperateLogService.page(page);
        return CommonResult.success(resultPage);
    }


}

