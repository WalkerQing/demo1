package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsRolePermissionRelation;
import com.example.docker.composes.demo.mall.service.IUmsRolePermissionRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 后台用户角色和权限关系表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-role-permission-relation")
public class UmsRolePermissionRelationController {
    @Autowired
    IUmsRolePermissionRelationService umsRolePermissionRelationService;

    @ApiOperation("get UmsRolePermissionRelation")
    @GetMapping("getUmsRolePermissionRelation")
    public CommonResult getUmsRolePermissionRelation(Long id){
        CommonResult<UmsRolePermissionRelation> commonResult;
        UmsRolePermissionRelation umsRolePermissionRelation = umsRolePermissionRelationService.getById(id);
        commonResult = umsRolePermissionRelation == null ? CommonResult.failed() : CommonResult.success(umsRolePermissionRelation);
        return commonResult;
    }



    @ApiOperation("UmsRolePermissionRelation list")
    @GetMapping("listUmsRolePermissionRelation")
    public CommonResult listUmsRolePermissionRelation(){
        CommonResult<List<UmsRolePermissionRelation>> commonResult;
        List<UmsRolePermissionRelation> umsRolePermissionRelations = umsRolePermissionRelationService.list();
        commonResult = umsRolePermissionRelations == null ? CommonResult.failed() : CommonResult.success(umsRolePermissionRelations);
        return commonResult;
    }


    @ApiOperation("save UmsRolePermissionRelation")
    @PostMapping("save")
    public CommonResult saveUmsRolePermissionRelation(UmsRolePermissionRelation umsRolePermissionRelation){
        CommonResult<String> commonResult;
        boolean result = umsRolePermissionRelationService.save(umsRolePermissionRelation);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsRolePermissionRelation")
    @PostMapping("delete")
    public CommonResult deleteUmsRolePermissionRelation(Long id){
        CommonResult<String> commonResult;
        boolean result = umsRolePermissionRelationService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

