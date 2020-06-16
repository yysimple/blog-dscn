package com.jxkj.managecenter.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jxkj.managecenter.entity.CategoryColumn;
import com.jxkj.managecenter.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Repository
public interface CategoryColumnMapper extends BaseMapper<CategoryColumn> {

    /**
     * 功能描述: 保存分类专栏信息
     *
     * @param categoryColumn
     * @return void
     * @Author wcx
     **/
    void saveCategoryColumn(CategoryColumn categoryColumn);

    /**
     * 功能描述: 根据分类专栏名获取分类专栏
     *
     * @param categoryName
     * @return com.jxkj.managecenter.entity.CategoryColumn
     * @Author wcx
     **/
    CategoryColumn getCategoryByCategoryName(String categoryName);
}
