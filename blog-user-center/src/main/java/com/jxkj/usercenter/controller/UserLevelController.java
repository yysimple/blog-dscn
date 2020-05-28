package com.jxkj.usercenter.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.service.IUserLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户等级表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/user-level")
@Api(tags = "积分等级表")
public class UserLevelController {

    @Autowired
    private IUserLevelService iUserLevelService;

    @PostMapping("/increaseIntegral")
    @ApiOperation(value = "增加积分")
    public ResultBody increaseIntegral(Long userId, Integer integral){
        return iUserLevelService.increaseIntegral(userId, integral);
    }

    @PostMapping("/queryLevel")
    @ApiOperation(value = "查询等级")
    public ResultBody updateLevel(Long userId){
        return iUserLevelService.updateLevel(userId);
    }


}
