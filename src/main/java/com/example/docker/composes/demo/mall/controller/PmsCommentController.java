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


import com.example.docker.composes.demo.mall.entity.PmsComment;
import com.example.docker.composes.demo.mall.service.IPmsCommentService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 商品评价表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-05
*/
@Api
@RestController
@RequestMapping("/mall/pms-comment")
public class PmsCommentController {
    @Autowired
    IPmsCommentService pmsCommentService;

    @ApiOperation("get PmsComment")
    @GetMapping("getPmsComment")
    public CommonResult getPmsComment(Long id){
        CommonResult<PmsComment> commonResult;
        PmsComment pmsComment = pmsCommentService.getById(id);
        commonResult = pmsComment == null ? CommonResult.failed() : CommonResult.success(pmsComment);
        return commonResult;
    }



    @ApiOperation("PmsComment list")
    @GetMapping("listPmsComment")
    public CommonResult listPmsComment(){
        CommonResult<List<PmsComment>> commonResult;
        List<PmsComment> pmsComments = pmsCommentService.list();
        commonResult = pmsComments == null ? CommonResult.failed() : CommonResult.success(pmsComments);
        return commonResult;
    }


    @ApiOperation("save PmsComment")
    @PostMapping("save")
    public CommonResult savePmsComment(PmsComment pmsComment){
        CommonResult<String> commonResult;
        boolean result = pmsCommentService.save(pmsComment);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("update PmsComment")
    @PostMapping("update")
    public CommonResult updatePmsComment(PmsComment pmsComment){
        CommonResult<String> commonResult;
        boolean result = pmsCommentService.updateById(pmsComment);
        commonResult = result ? CommonResult.success("修改成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsComment")
    @PostMapping("delete")
    public CommonResult deletePmsComment(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsCommentService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    } 
    @ApiOperation("page PmsComment list")
    @PostMapping("/page")
    public CommonResult<IPage> page(@RequestParam(value = "pageNum", defaultValue = "1")
        @ApiParam("页码") Integer pageNum,
        @RequestParam(value = "pageSize", defaultValue = "3")
        @ApiParam("每页数量") Integer pageSize) {
        IPage<PmsComment> page = new Page<>(pageNum,pageSize);
        IPage<PmsComment> resultPage = pmsCommentService.page(page);
        return CommonResult.success(resultPage);
    }


}

