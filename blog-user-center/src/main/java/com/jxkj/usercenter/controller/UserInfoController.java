package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.entity.UserInfo;
import com.jxkj.usercenter.service.IUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户详细信息 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/user-info")
@Api(tags = "用户详细信息表")
public class UserInfoController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @ApiOperation(value = "根据用户id查询详细信息")
    @GetMapping("/selectById")
    public ResultBody selectById(@RequestParam("id") Long id){
        return iUserInfoService.selectById(id);
    }

    @ApiOperation(value = "保存用户详细信息")
    @PostMapping("/saveMessage")
    public ResultBody saveMessage(UserInfo userInfo){
        return iUserInfoService.saveMessage(userInfo);
    }

    @ApiOperation(value = "更改用户详细信息")
    @PostMapping("/update")
    public ResultBody update(UserInfo userInfo){
        return iUserInfoService.update(userInfo);
    }
}
