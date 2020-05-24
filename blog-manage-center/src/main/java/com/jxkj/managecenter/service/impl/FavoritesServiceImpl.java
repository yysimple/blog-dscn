package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.mapper.FavoritesMapper;
import com.jxkj.managecenter.service.IFavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 收藏夹表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements IFavoritesService {

    @Autowired
    private FavoritesMapper favoritesMapper;

    @Autowired
    private IFavoritesService iFavoritesService;

    private QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();

    @Override
    public ResultBody findExistFavorites(Favorites favorites) {
        List<Favorites> favoritesName = favoritesMapper.selectList(queryWrapper.eq("favorites_name", favorites.getTUserId()));
        boolean exist = favoritesName.stream().anyMatch(u -> u.getFavoritesName().equals(favorites.getFavoritesName()));
        if (!exist) {
            iFavoritesService.saveOrUpdate(favorites);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.ALREADY_EXIST.getCode(),
                    ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @Override
    public ResultBody finaUserFavorites(Long userId) {
        queryWrapper.eq("t_user_id", userId);
        return ResultBodyUtil.success(favoritesMapper.selectList(queryWrapper));
    }
}
