package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.managecenter.entity.BlogType;
import com.jxkj.managecenter.entity.CategoryColumn;
import com.jxkj.managecenter.mapper.BlogTypeMapper;
import com.jxkj.managecenter.mapper.CategoryColumnMapper;
import com.jxkj.managecenter.service.ICategoryColumnService;
import org.springframework.stereotype.Service;

/**
 * 分类专栏(TCategoryColumn)表服务实现类
 *
 * @author makejava
 * @since 2020-06-12 23:14:37
 */
@Service
public class ICategoryColumnServiceImpl extends ServiceImpl<CategoryColumnMapper, CategoryColumn> implements ICategoryColumnService {

}