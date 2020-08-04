package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsAdminRoleRelation;
import com.example.docker.composes.demo.mall.service.IUmsAdminRoleRelationService;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
* <p>
    * 后台用户和角色关系表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-admin-role-relation")
public class UmsAdminRoleRelationController {
    @Autowired
    IUmsAdminRoleRelationService umsAdminRoleRelationService;

    @ApiOperation("get UmsAdminRoleRelation")
    @GetMapping("getUmsAdminRoleRelation")
    public CommonResult getUmsAdminRoleRelation(Long id){
        CommonResult<UmsAdminRoleRelation> commonResult;
        UmsAdminRoleRelation umsAdminRoleRelation = umsAdminRoleRelationService.getById(id);
        commonResult = umsAdminRoleRelation == null ? CommonResult.failed() : CommonResult.success(umsAdminRoleRelation);
        return commonResult;
    }



    @ApiOperation("UmsAdminRoleRelation list")
    @GetMapping("listUmsAdminRoleRelation")
    public CommonResult listUmsAdminRoleRelation(){
        CommonResult<List<UmsAdminRoleRelation>> commonResult;
        List<UmsAdminRoleRelation> umsAdminRoleRelations = umsAdminRoleRelationService.list();
        commonResult = umsAdminRoleRelations == null ? CommonResult.failed() : CommonResult.success(umsAdminRoleRelations);
        return commonResult;
    }


    @ApiOperation("save UmsAdminRoleRelation")
    @PostMapping("save")
    public CommonResult saveUmsAdminRoleRelation(UmsAdminRoleRelation umsAdminRoleRelation){
        CommonResult<String> commonResult;
        boolean result = umsAdminRoleRelationService.save(umsAdminRoleRelation);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsAdminRoleRelation")
    @PostMapping("delete")
    public CommonResult deleteUmsAdminRoleRelation(Long id){
        CommonResult<String> commonResult;
        boolean result = umsAdminRoleRelationService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

}

