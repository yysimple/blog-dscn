package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.entity.Favorites;

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
     * 功能描述: 新建or更新收藏夹
     *          查询收藏夹是否已存在(忽略大小写)
     *
     * @author GuJunBin
     * @param favorites
     * @return java.lang.Boolean
     */
    ResultBody findExistFavorites(Favorites favorites);

    /**
     * 功能描述: 查询用户收藏夹
     *
     * @author GuJunBin
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody findFavoritesByUserId(Long userId);

    /**
     * 功能描述: 删除收藏夹
     *
     * @author GuJunBin
     * @param id
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody deleteById(Long id, Long userId);

    /**
     * 功能描述: 查询对应收藏夹下的博客信息
     *
     * @Author wcx
     * @param favoriteId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody findAllBlogFavoriteId(Long favoriteId);
}
