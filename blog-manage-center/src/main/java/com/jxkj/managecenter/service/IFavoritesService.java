package com.jxkj.managecenter.service;

import com.jxkj.managecenter.entity.Favorites;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 收藏夹表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IFavoritesService extends IService<Favorites> {

    /**
     * @Description: 查询收藏夹是否已存在
     *
     * @author GuJunBin
     * @param favorites
     * @return java.lang.Boolean
     */
    Boolean findExistFavorites(Favorites favorites);
}
