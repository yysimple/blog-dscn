package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.mapper.IndustryMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 行业表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/industry")
@Api(tags = "行业")
public class IndustryController {

    @Autowired
    private IndustryMapper industryMapper;

    @GetMapping("/getAllIndustry")
    @ApiOperation(value = "获取所有的行业")
    public ResultBody getAllIndustry(){
        return ResultBodyUtil.success(industryMapper.selectList(null));
    }
}
