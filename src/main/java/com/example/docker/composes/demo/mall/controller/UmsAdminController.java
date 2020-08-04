package com.example.docker.composes.demo.mall.controller;

import com.example.docker.composes.demo.mall.dto.UmsAdminLoginParam;
import com.example.docker.composes.demo.mall.entity.UmsPermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsAdmin;
import com.example.docker.composes.demo.mall.service.IUmsAdminService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* <p>
    * 后台用户表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-admin")
public class UmsAdminController {
    @Autowired
    IUmsAdminService umsAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation("get UmsAdmin")
    @GetMapping("getUmsAdmin")
    public CommonResult getUmsAdmin(Long id){
        CommonResult<UmsAdmin> commonResult;
        UmsAdmin umsAdmin = umsAdminService.getById(id);
        commonResult = umsAdmin == null ? CommonResult.failed() : CommonResult.success(umsAdmin);
        return commonResult;
    }



    @ApiOperation("UmsAdmin list")
    @GetMapping("listUmsAdmin")
    public CommonResult listUmsAdmin(){
        CommonResult<List<UmsAdmin>> commonResult;
        List<UmsAdmin> umsAdmins = umsAdminService.list();
        commonResult = umsAdmins == null ? CommonResult.failed() : CommonResult.success(umsAdmins);
        return commonResult;
    }


    @ApiOperation("save UmsAdmin")
    @PostMapping("save")
    public CommonResult saveUmsAdmin(UmsAdmin umsAdmin){
        CommonResult<String> commonResult;
        boolean result = umsAdminService.save(umsAdmin);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsAdmin")
    @PostMapping("delete")
    public CommonResult deleteUmsAdmin(Long id){
        CommonResult<String> commonResult;
        boolean result = umsAdminService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("get UmsAdmin by username")
    @PostMapping("getUmsAdminByUsername")
    public CommonResult getUmsAdminByUsername(String username){
        CommonResult<UmsAdmin> commonResult;
        UmsAdmin umsAdmin = umsAdminService.getAdminByUsername(username);
        commonResult = umsAdmin != null ? CommonResult.success(umsAdmin) : CommonResult.failed();
        return commonResult;
    }


    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping(value = "/login")
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @GetMapping(value = "/permission/{adminId}")
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }
}

