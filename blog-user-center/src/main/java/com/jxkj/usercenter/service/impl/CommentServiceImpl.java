package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.Comment;
import com.jxkj.usercenter.mapper.CommentMapper;
import com.jxkj.usercenter.service.ICommentService;
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
