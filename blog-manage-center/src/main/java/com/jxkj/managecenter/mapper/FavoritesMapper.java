package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.Favorites;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 收藏夹表 Mapper 接口
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Repository
public interface FavoritesMapper extends BaseMapper<Favorites> {

    /**
     * 功能描述: 查询对应收藏夹下的博客信息
     *
     * @Author wcx
     * @param favoriteId
     * @return com.jxkj.managecenter.entity.Favorites
     **/
    Favorites findAllBlogFavoriteId(Long favoriteId);

}
