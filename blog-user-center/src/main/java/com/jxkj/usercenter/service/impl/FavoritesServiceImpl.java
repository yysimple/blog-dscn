package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.Favorites;
import com.jxkj.usercenter.mapper.FavoritesMapper;
import com.jxkj.usercenter.service.IFavoritesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 收藏夹表 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites> implements IFavoritesService {

}
