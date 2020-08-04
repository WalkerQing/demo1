package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.PmsBrand;
import com.example.docker.composes.demo.mall.service.IPmsBrandService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 品牌表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/pms-brand")
public class PmsBrandController {
    @Autowired
    IPmsBrandService pmsBrandService;

    @ApiOperation("get PmsBrand")
    @GetMapping("getPmsBrand")
    public CommonResult getPmsBrand(Long id){
        CommonResult<PmsBrand> commonResult;
        PmsBrand pmsBrand = pmsBrandService.getById(id);
        commonResult = pmsBrand == null ? CommonResult.failed() : CommonResult.success(pmsBrand);
        return commonResult;
    }


    @PreAuthorize("hasAuthority('pms:brand:read')")
    @ApiOperation("PmsBrand list")
    @GetMapping("listPmsBrand")
    public CommonResult listPmsBrand(){
        CommonResult<List<PmsBrand>> commonResult;
        List<PmsBrand> pmsBrands = pmsBrandService.list();
        commonResult = pmsBrands == null ? CommonResult.failed() : CommonResult.success(pmsBrands);
        return commonResult;
    }


    @ApiOperation("save PmsBrand")
    @PostMapping("save")
    public CommonResult savePmsBrand(PmsBrand pmsBrand){
        CommonResult<String> commonResult;
        boolean result = pmsBrandService.save(pmsBrand);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete PmsBrand")
    @PostMapping("delete")
    public CommonResult deletePmsBrand(Long id){
        CommonResult<String> commonResult;
        boolean result = pmsBrandService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

