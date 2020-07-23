package com.jxkj.managecenter.service;

import com.jxkj.common.result.ResultBody;

/**
 * 项目: blog-dscn
 *
 * 功能描述: 异步编排实现类
 *
 * @author: WuChengXing
 * @create: 2020-07-23 10:12
 **/
public interface BlogIndexService {
    /**
     * 功能描述: 通过异步编排的方式返回首页所有的信息
     * @author WuChengxing
     * @date 2020/7/23
     * @param blogTagId
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody getIndexDetails(Long userId, Long blogTagId);

    /**
     * 功能描述: 通过异步编排的方式去进行查询操作
     * @author WuChengxing
     * @date 2020/7/23
     * @param userId
     * @param blogTagId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody getIndexDetailsByCompletable(Long userId, Long blogTagId);
}
