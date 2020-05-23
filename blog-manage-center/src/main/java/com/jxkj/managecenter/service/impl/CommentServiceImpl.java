package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Comment;
import com.jxkj.managecenter.mapper.CommentMapper;
import com.jxkj.managecenter.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

    @Autowired
    private CommentMapper commentMapper;

    private QueryWrapper<Comment> queryWrapper = Wrappers.query();
    IPage<Comment> page = new Page(1, 10);

    @Override
    public ResultBody listComment(Long tBlogInfoId) {
        queryWrapper.eq("t_blog_info_id", tBlogInfoId);
        return ResultBodyUtil.success(commentMapper.selectPage(page,queryWrapper));
    }
}
