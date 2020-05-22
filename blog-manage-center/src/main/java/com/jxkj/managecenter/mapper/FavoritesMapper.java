package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.Favorites;
import org.apache.ibatis.annotations.Param;
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
     * @Description: 根据用户id 查询用户所有收藏夹名称
     *
     * @author GuJunBin
     * @param userId
     * @return java.util.List
     */
    List<String> selectFavoritesNameByUserId(@Param("userId") Long userId);
}
