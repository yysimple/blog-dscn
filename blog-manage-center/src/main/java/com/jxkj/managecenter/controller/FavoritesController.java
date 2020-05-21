package com.jxkj.managecenter.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.service.IFavoritesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "新建收藏夹")
    @PostMapping("/createFavorites")
    public ResultBody createFavorites(@RequestParam Long userId,@RequestParam String favoritesName) {
        //TODO
        List<Favorites> list = iFavoritesService.list(queryWrapper.eq("t_user_id", userId).eq("favorites_name", favoritesName));
        if (list.isEmpty()) {
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }

    }

    @ApiOperation(value = "查询用户收藏夹")
    @GetMapping("/finaUserFavorites")
    public ResultBody finaAllFavorites(Long userid) {
        List<Favorites> favoritesList = iFavoritesService.list(queryWrapper.eq("t_user_id", userid));
        return ResultBodyUtil.success(favoritesList);
    }

    public ResultBody updateUserFavorites() {
        //TODO
        return ResultBodyUtil.success();
    }
}

