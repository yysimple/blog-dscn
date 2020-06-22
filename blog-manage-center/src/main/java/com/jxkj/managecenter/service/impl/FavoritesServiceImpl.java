package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.result.ResultTypeEnum;
import com.jxkj.managecenter.entity.BlogFavoritesUser;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.mapper.BlogFavoritesUserMapper;
import com.jxkj.managecenter.mapper.FavoritesMapper;
import com.jxkj.managecenter.service.IFavoritesService;
import com.jxkj.managecenter.vo.FavoritesBlogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    private BlogFavoritesUserMapper blogFavoritesUserMapper;

    @Autowired
    private IFavoritesService iFavoritesService;

    private QueryWrapper<Favorites> queryWrapper = new QueryWrapper<>();

    @Override
    public ResultBody findExistFavorites(Favorites favorites) {
        List<Favorites> favoritesList = favoritesMapper.selectList(queryWrapper.eq("t_user_id", favorites.getTUserId()));
        boolean exist = favoritesList.stream().anyMatch(u -> u.getFavoritesName().equalsIgnoreCase(favorites.getFavoritesName()));
        if (!exist) {
            iFavoritesService.saveOrUpdate(favorites);
            return ResultBodyUtil.success();
        } else {
            return ResultBodyUtil.error(ResultTypeEnum.ALREADY_EXIST.getCode(), ResultTypeEnum.ALREADY_EXIST.getMsg());
        }
    }

    @Override
    public ResultBody findFavoritesByUserId(Long userId) {
        List<FavoritesBlogVO> favoritesBlogVOS = new ArrayList<>();
        queryWrapper.eq("t_user_id", userId);
        List<Favorites> favorites = favoritesMapper.selectList(queryWrapper);
        for (Favorites favorite : favorites) {
            FavoritesBlogVO favoritesBlogVO = new FavoritesBlogVO();
            Favorites favorites1 = favoritesMapper.findAllBlogFavoriteId(favorite.getId());
            favoritesBlogVO.setFavorite(favorites1);
            Integer blogNum = favorites1.getBlogInfos().size();
            favoritesBlogVO.setBlogNum(blogNum);
            favoritesBlogVOS.add(favoritesBlogVO);
        }
        return ResultBodyUtil.success(favoritesBlogVOS);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResultBody deleteById(Long id, Long userId) {
        Favorites favorites = favoritesMapper.selectById(id);
        if (favorites.getTUserId().equals(userId)){
            favoritesMapper.deleteById(id);
        }
        QueryWrapper<BlogFavoritesUser> queryWrapper = new QueryWrapper<>();
        List<BlogFavoritesUser> blogFavoritesUsers = blogFavoritesUserMapper.selectList(queryWrapper.eq("favorites_id", id).eq("user_id", userId));
        if (blogFavoritesUsers != null){
            ArrayList<Long> idList = new ArrayList<>();
            for (BlogFavoritesUser blogFavoritesUser : blogFavoritesUsers) {
                idList.add(blogFavoritesUser.getId());
            }
            blogFavoritesUserMapper.deleteBatchIds(idList);
        }
        return ResultBodyUtil.success();
    }

    @Override
    public ResultBody findAllBlogFavoriteId(Long favoriteId) {
        Favorites favorites = favoritesMapper.findAllBlogFavoriteId(favoriteId);
        FavoritesBlogVO favoritesBlogVO = new FavoritesBlogVO();
        favoritesBlogVO.setFavorite(favorites);
        Integer blogNum = favorites.getBlogInfos().size();
        favoritesBlogVO.setBlogNum(blogNum);
        return ResultBodyUtil.success(favoritesBlogVO);
    }
}
