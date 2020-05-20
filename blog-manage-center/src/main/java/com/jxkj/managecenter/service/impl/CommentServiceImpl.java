package com.jxkj.managecenter.service.impl;

import com.jxkj.managecenter.entity.Comment;
import com.jxkj.managecenter.mapper.CommentMapper;
import com.jxkj.managecenter.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
