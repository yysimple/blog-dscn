package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

    @Override
    public Boolean findExistFavorites(Favorites favorites) {
        List<String> list = favoritesMapper.selectFavoritesNameByUserId(favorites.getTUserId());
        boolean contains = list.contains(favorites.getFavoritesName());
        return contains;
    }
}
