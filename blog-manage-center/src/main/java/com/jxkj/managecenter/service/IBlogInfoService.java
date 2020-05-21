package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.managecenter.entity.BlogInfo;

/**
 * <p>
 * 博客基本信息表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface IBlogInfoService extends IService<BlogInfo> {

    /**
     * @Description: 根据博客id逻辑删除博客, 更改博客删除状态为 1
     *
     * @author GuJunBin
     * @param id
     * @return void
     */
    void updateDelStatusById(Long id);
}
