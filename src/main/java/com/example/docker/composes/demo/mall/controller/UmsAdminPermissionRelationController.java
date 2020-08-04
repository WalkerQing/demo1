package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsAdminPermissionRelation;
import com.example.docker.composes.demo.mall.service.IUmsAdminPermissionRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 后台用户和权限关系表(除角色中定义的权限以外的加减权限) 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-admin-permission-relation")
public class UmsAdminPermissionRelationController {
    @Autowired
    IUmsAdminPermissionRelationService umsAdminPermissionRelationService;

    @ApiOperation("get UmsAdminPermissionRelation")
    @GetMapping("getUmsAdminPermissionRelation")
    public CommonResult getUmsAdminPermissionRelation(Long id){
        CommonResult<UmsAdminPermissionRelation> commonResult;
        UmsAdminPermissionRelation umsAdminPermissionRelation = umsAdminPermissionRelationService.getById(id);
        commonResult = umsAdminPermissionRelation == null ? CommonResult.failed() : CommonResult.success(umsAdminPermissionRelation);
        return commonResult;
    }



    @ApiOperation("UmsAdminPermissionRelation list")
    @GetMapping("listUmsAdminPermissionRelation")
    public CommonResult listUmsAdminPermissionRelation(){
        CommonResult<List<UmsAdminPermissionRelation>> commonResult;
        List<UmsAdminPermissionRelation> umsAdminPermissionRelations = umsAdminPermissionRelationService.list();
        commonResult = umsAdminPermissionRelations == null ? CommonResult.failed() : CommonResult.success(umsAdminPermissionRelations);
        return commonResult;
    }


    @ApiOperation("save UmsAdminPermissionRelation")
    @PostMapping("save")
    public CommonResult saveUmsAdminPermissionRelation(UmsAdminPermissionRelation umsAdminPermissionRelation){
        CommonResult<String> commonResult;
        boolean result = umsAdminPermissionRelationService.save(umsAdminPermissionRelation);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsAdminPermissionRelation")
    @PostMapping("delete")
    public CommonResult deleteUmsAdminPermissionRelation(Long id){
        CommonResult<String> commonResult;
        boolean result = umsAdminPermissionRelationService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

