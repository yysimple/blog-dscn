package com.jxkj.blogsystem.controller;


import com.jxkj.blogsystem.entity.BannerInfo;
import com.jxkj.blogsystem.mapper.BannerInfoMapper;
import com.jxkj.blogsystem.service.IBannerInfoService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ysq
 * @since 2020-06-04
 */
@RestController
@RequestMapping("/banner-info")
public class BannerInfoController {

    @Autowired
    private IBannerInfoService iBannerInfoService;

    @Autowired
    private BannerInfoMapper bannerInfoMapper;

    @ApiOperation(value = "查找所有的banner信息")
    @GetMapping("/findAllBannerInfo")
    public ResultBody findAllBannerInfo() {
        return ResultBodyUtil.success(iBannerInfoService.list());
    }

    @ApiOperation(value = "修改banner的信息")
    @PostMapping("/updateBannerInfo")
    public ResultBody updateBannerInfo(@RequestBody BannerInfo bannerInfo) {
        return ResultBodyUtil.success(bannerInfoMapper.updateById(bannerInfo));
    }

    @ApiOperation(value = "通过banner删除一条banner信息")
    @PostMapping("/deleteBannerInfoById")
    public ResultBody deleteBannerInfoById(Long bannerInfoId) {
        return ResultBodyUtil.success(bannerInfoMapper.deleteById(bannerInfoId));
    }

    @ApiOperation(value = "新增一条banner记录")
    @PostMapping("/insertBannerInfo")
    public ResultBody insertBannerInfo(@RequestBody BannerInfo bannerInfo) {
        return ResultBodyUtil.success(bannerInfoMapper.insert(bannerInfo));
    }
}
