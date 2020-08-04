package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsRole;
import com.example.docker.composes.demo.mall.service.IUmsRoleService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 后台用户角色表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-role")
public class UmsRoleController {
    @Autowired
    IUmsRoleService umsRoleService;

    @ApiOperation("get UmsRole")
    @GetMapping("getUmsRole")
    public CommonResult getUmsRole(Long id){
        CommonResult<UmsRole> commonResult;
        UmsRole umsRole = umsRoleService.getById(id);
        commonResult = umsRole == null ? CommonResult.failed() : CommonResult.success(umsRole);
        return commonResult;
    }



    @ApiOperation("UmsRole list")
    @GetMapping("listUmsRole")
    public CommonResult listUmsRole(){
        CommonResult<List<UmsRole>> commonResult;
        List<UmsRole> umsRoles = umsRoleService.list();
        commonResult = umsRoles == null ? CommonResult.failed() : CommonResult.success(umsRoles);
        return commonResult;
    }


    @ApiOperation("save UmsRole")
    @PostMapping("save")
    public CommonResult saveUmsRole(UmsRole umsRole){
        CommonResult<String> commonResult;
        boolean result = umsRoleService.save(umsRole);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsRole")
    @PostMapping("delete")
    public CommonResult deleteUmsRole(Long id){
        CommonResult<String> commonResult;
        boolean result = umsRoleService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

