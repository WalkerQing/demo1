package com.example.docker.composes.demo.mall.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.docker.composes.demo.mall.common.api.CommonResult;


import com.example.docker.composes.demo.mall.entity.UmsMember;
import com.example.docker.composes.demo.mall.service.IUmsMemberService;

import java.util.List;

/**
* <p>
    * 会员表 前端控制器
    * </p>
*
* @author qy
* @since 2020-08-04
*/
@Api
@RestController
@RequestMapping("/mall/ums-member")
public class UmsMemberController {
    @Autowired
    IUmsMemberService umsMemberService;

    @ApiOperation("get UmsMember")
    @GetMapping("getUmsMember")
    public CommonResult getUmsMember(Long id){
        CommonResult<UmsMember> commonResult;
        UmsMember umsMember = umsMemberService.getById(id);
        commonResult = umsMember == null ? CommonResult.failed() : CommonResult.success(umsMember);
        return commonResult;
    }



    @ApiOperation("UmsMember list")
    @GetMapping("listUmsMember")
    public CommonResult listUmsMember(){
        CommonResult<List<UmsMember>> commonResult;
        List<UmsMember> umsMembers = umsMemberService.list();
        commonResult = umsMembers == null ? CommonResult.failed() : CommonResult.success(umsMembers);
        return commonResult;
    }


    @ApiOperation("save UmsMember")
    @PostMapping("save")
    public CommonResult saveUmsMember(UmsMember umsMember){
        CommonResult<String> commonResult;
        boolean result = umsMemberService.save(umsMember);
        commonResult = result ? CommonResult.success("插入成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("delete UmsMember")
    @PostMapping("delete")
    public CommonResult deleteUmsMember(Long id){
        CommonResult<String> commonResult;
        boolean result = umsMemberService.removeById(id);
        commonResult = result ? CommonResult.success("删除成功") : CommonResult.failed();
        return commonResult;
    }

    @ApiOperation("获取验证码")
    @GetMapping(value = "/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone) {
        return umsMemberService.generateAuthCode(telephone);
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    public CommonResult updatePassword(@RequestParam String telephone,
                                       @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(telephone,authCode);
    }

}

