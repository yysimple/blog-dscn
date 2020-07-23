package com.jxkj.managecenter.vo;

import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogTag;
import lombok.Data;

import java.util.List;

/**
 * @program: blog-dscn
 * @description: 博客首页需要的信息VO
 * @author: WuChengXing
 * @create: 2020-07-23 10:07
 **/
@Data
public class BlogIndexVO {

    /**
     * 首页需要所有的博客标签信息
     */
    private List<BlogTag> blogTags;

    /**
     * 首页需要的用户信息
     */
    private UserVO userVO;

    /**
     * 所有的博客信息、包含其对应的用户信息
     */
    private List<BlogInfoIndexVO> blogInfoIndexVOList;
}
