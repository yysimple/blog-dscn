package com.jxkj.usercenter.service.impl;

import com.jxkj.usercenter.entity.TComment;
import com.jxkj.usercenter.mapper.TCommentMapper;
import com.jxkj.usercenter.service.ITCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author gjb
 * @since 2020-05-19
 */
@Service
public class TCommentServiceImpl extends ServiceImpl<TCommentMapper, TComment> implements ITCommentService {

}
