package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsPermission;
import com.example.docker.composes.demo.mall.service.IUmsPermissionService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 后台用户权限表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-permission")
public class UmsPermissionController {
    @Autowired
    IUmsPermissionService umsPermissionService;

    @ApiOperation("get UmsPermission")
    @GetMapping("getUmsPermission")
    public CommonResult getUmsPermission(Long id){
        CommonResult<UmsPermission> commonResult;
        UmsPermission umsPermission = umsPermissionService.getById(id);
        commonResult = umsPermission == null ? CommonResult.failed() : CommonResult.success(umsPermission);
        return commonResult;
    }



    @ApiOperation("UmsPermission list")
    @GetMapping("listUmsPermission")
    public CommonResult listUmsPermission(){
        CommonResult<List<UmsPermission>> commonResult;
        List<UmsPermission> umsPermissions = umsPermissionService.list();
        commonResult = umsPermissions == null ? CommonResult.failed() : CommonResult.success(umsPermissions);
        return commonResult;
    }


    @ApiOperation("save UmsPermission")
    @PostMapping("save")
    public CommonResult saveUmsPermission(UmsPermission umsPermission){
        CommonResult<String> commonResult;
        boolean result = umsPermissionService.save(umsPermission);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsPermission")
    @PostMapping("delete")
    public CommonResult deleteUmsPermission(Long id){
        CommonResult<String> commonResult;
        boolean result = umsPermissionService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

