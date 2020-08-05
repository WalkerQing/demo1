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


import com.example.docker.composes.demo.mall.entity.PmsCommentReplay;
import com.example.docker.composes.demo.mall.service.IPmsCommentReplayService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 产品评价回复表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-comment-replay")
public class PmsCommentReplayController {
    @Autowired
    IPmsCommentReplayService pmsCommentReplayService;

    @ApiOperation("get PmsCommentReplay")
    @GetMapping("getPmsCommentReplay")
    public CommonResult getPmsCommentReplay(Long id){
        CommonResult<PmsCommentReplay> commonResult;
        PmsCommentReplay pmsCommentReplay = pmsCommentReplayService.getById(id);
        commonResult = pmsCommentReplay == null ? CommonResult.failed() : CommonResult.success(pmsCommentReplay);
        return commonResult;
    }



    @ApiOperation("PmsCommentReplay list")
    @GetMapping("listPmsCommentReplay")
    public CommonResult listPmsCommentReplay(){
        CommonResult<List<PmsCommentReplay>> commonResult;
        List<PmsCommentReplay> pmsCommentReplays = pmsCommentReplayService.list();
        commonResult = pmsCommentReplays == null ? CommonResult.failed() : CommonResult.success(pmsCommentReplays);
        return commonResult;
    }


    @ApiOperation("save PmsCommentReplay")
    @PostMapping("save")
    public CommonResult savePmsCommentReplay(PmsCommentReplay pmsCommentReplay){
        CommonResult<String> commonResult;
        boolean result = pmsCommentReplayService.save(pmsCommentReplay);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsCommentReplay")
    @PostMapping("update")
    public CommonResult updatePmsCommentReplay(PmsCommentReplay pmsCommentReplay){
        CommonResult<String> commonResult;
        boolean result = pmsCommentReplayService.updateById(pmsCommentReplay);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsCommentReplay")
    @PostMapping("delete")
    public CommonResult deletePmsCommentReplay(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsCommentReplayService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsCommentReplay list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsCommentReplay> page = new Page<>(pageNum,pageSize);
        IPage<PmsCommentReplay> resultPage = pmsCommentReplayService.page(page);
        return CommonResult.success(resultPage);
    }


}

