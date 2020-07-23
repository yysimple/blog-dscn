package com.jxkj.managecenter.vo;

import lombok.Data;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 首页详情里面的博客信息VO
 *
 * @author: WuChengXing
 * @create: 2020-07-23 10:25
 **/
@Data
public class BlogInfoIndexVO {

    /**
     * 查询所有的博客信息的vo
     */
    private BlogInfoVO blogInfoVO;

    /**
     * 查询该篇博客对应的用户信息
     */
    private UserVO userVO;
}
