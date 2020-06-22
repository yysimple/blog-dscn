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
@RequestMapping("favorites")
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
    @GetMapping("/findFavoritesByUserId")
    public ResultBody findFavoritesByUserId(@RequestParam("userId") Long userId) {
        return iFavoritesService.findFavoritesByUserId(userId);
    }

    @ApiOperation(value = "删除收藏夹")
    @PostMapping("/deleteById")
    public ResultBody deleteById(@RequestParam("id") Long id, @RequestParam("userId") Long userId) {
        iFavoritesService.deleteById(id, userId);
        return ResultBodyUtil.success();
    }

    @GetMapping("/findAllBlogFavoriteId")
    @ApiOperation(value = "查询对应收藏夹下的博客信息")
    public ResultBody findAllBlogFavoriteId(Long favoriteId){
        return iFavoritesService.findAllBlogFavoriteId(favoriteId);
    }
}

