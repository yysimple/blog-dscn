package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.service.IFavoritesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "用户收藏夹模块 接口")
@Slf4j
public class FavoritesController {

    @Autowired
    private IFavoritesService iFavoritesService;

    @ApiOperation(value = "新建or更新收藏夹")
    @PostMapping("/saveOrUpdateFavorites")
    public ResultBody saveOrUpdateFavorites(@RequestBody Favorites favorites) {
        return iFavoritesService.findExistFavorites(favorites);
    }

    @ApiOperation(value = "查询用户收藏夹")
    @GetMapping("/finaUserFavorites")
    public ResultBody finaUserFavorites(Long userId) {
        return iFavoritesService.finaUserFavorites(userId);
    }

    @ApiOperation(value = "删除收藏夹")
    @PostMapping("/deleteById")
    public ResultBody deleteById(Long id) {
        iFavoritesService.deleteById(id);
        return ResultBodyUtil.success();
    }
}

