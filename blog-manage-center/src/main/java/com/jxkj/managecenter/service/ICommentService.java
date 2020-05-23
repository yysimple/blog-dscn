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

    ResultBody listComment(Long tBlogInfoId);
}
