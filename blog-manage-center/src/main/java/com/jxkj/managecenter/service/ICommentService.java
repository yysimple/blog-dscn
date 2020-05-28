package com.jxkj.managecenter.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jxkj.common.result.ResultBody;
import com.jxkj.managecenter.entity.Comment;

/**
 * <p>
 * 评论表 服务类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
public interface ICommentService extends IService<Comment> {

    /**
     * 功能描述: 根据博客id分页查询所有留言
     *
     * @author GuJunBin
     * @param tBlogInfoId
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody listComment(Long tBlogInfoId);

    /**
     * 功能描述: 保存留言
     *
     * @author GuJunBin
     * @param comment
     * @return com.jxkj.common.result.ResultBody
     */
    ResultBody saveComment(Comment comment);
}
