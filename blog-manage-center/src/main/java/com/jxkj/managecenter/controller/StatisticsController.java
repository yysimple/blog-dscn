package com.jxkj.managecenter.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.service.StatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController
@RequestMapping("/statistics")
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

    @GetMapping("/getOneBlogStatistics")
    @ApiOperation(value = "获取单篇博客的统计信息")
    public ResultBody getOneBlogStatistics(Long blogId){
        return statisticsService.getOneBlogStatistics(blogId);
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

    @GetMapping("/countBlogNumber")
    @ApiOperation(value = "获取该用户所有的博客")
    public ResultBody countBlogNumber(Long userId){
        return statisticsService.countBlogNumber(userId);
    }

    @GetMapping("/countForChart")
    @ApiOperation(value = "用于图表数据")
    public ResultBody countForChart(){
        return statisticsService.countForChart();
    }

    @GetMapping("/countPageViewForChart")
    @ApiOperation(value = "统计用户博客被访问数")
    public ResultBody countPageViewForChart(Long userId){
        return statisticsService.countPageViewForChart(userId);
    }

    @GetMapping("/countBlogArchive")
    @ApiOperation(value = "博客归档")
    public ResultBody countBlogArchive(Long userId){
        return statisticsService.countBlogArchive(userId);
    }

    @GetMapping("/countBlogNumberInFavorites")
    @ApiOperation(value = "统计每个收藏夹下有多少篇博客")
    public ResultBody countBlogNumberInFavorites(Long favoriteId){
        return statisticsService.countBlogNumberInFavorites(favoriteId);
    }
}
