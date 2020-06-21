package com.jxkj.managecenter.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController("/statistics")
@Api(tags = "统计数据接口")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private BlogInfoMapper blogInfoMapper;

    @GetMapping("/allStatistics")
    @ApiOperation(value = "获取所有的统计条目")
    public ResultBody allStatistics(Long userId){
        return statisticsService.allStatistics(userId);
    }

    @GetMapping("/getAllBlogDetails")
    @ApiOperation(value = "获取所有博客详情")
    public ResultBody getAllBlogDetails(){
        return ResultBodyUtil.success(blogInfoMapper.findAllBlogDetails());
    }

    @GetMapping("/getAllStatisticsByUserId")
    @ApiOperation(value = "通过用户id查询所有博客信息")
    public ResultBody getAllStatisticsByUserId(Long userId){
        return ResultBodyUtil.success(blogInfoMapper.findAllBlogByUserId(userId));
    }
}
