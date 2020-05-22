package com.jxkj.managecenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.service.IFavoritesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 收藏夹表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/favorites")
@Api(tags = "博客收藏夹模块 接口")
@Slf4j
public class FavoritesController {

    @Autowired
    private IFavoritesService iFavoritesService;

    private QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();

    @ApiOperation(value = "新建or更新收藏夹")
    @PostMapping("/saveOrUpdateFavorites")
    public ResultBody saveOrUpdateFavorites(@RequestBody Favorites favorites) {
        Boolean existFavorites = iFavoritesService.findExistFavorites(favorites);
        if (!existFavorites) {
            iFavoritesService.saveOrUpdate(favorites);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @ApiOperation(value = "查询用户收藏夹")
    @GetMapping("/finaUserFavorites")
    public ResultBody finaAllFavorites(@ApiParam(value = "用户id") Long userId) {
        List<Favorites> favoritesList = iFavoritesService.list(queryWrapper.eq("t_user_id", userId));
        return ResultBodyUtil.success(favoritesList);
    }

    @ApiOperation(value = "删除收藏夹")
    @PostMapping("/deleteFavorites")
    public ResultBody deleteFavorites(@ApiParam(value = "收藏夹id") Long id) {
        iFavoritesService.removeById(id);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "批量删除收藏夹")
    @PostMapping("/batchDeleteFavorites")
    public ResultBody batchDeleteFavorites(@RequestParam("idList[]") Collection idList) {
        iFavoritesService.removeByIds(idList);
        return ResultBodyUtil.success();
    }
}

