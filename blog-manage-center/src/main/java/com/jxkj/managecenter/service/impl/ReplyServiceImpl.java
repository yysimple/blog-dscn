package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Reply;
import com.jxkj.managecenter.mapper.ReplyMapper;
import com.jxkj.managecenter.service.IReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 回复表 服务实现类
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements IReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    private QueryWrapper<Reply> queryWrapper = new QueryWrapper<>();

    @Override
    public ResultBody listReply(Long commentId) {
        queryWrapper.eq("t_comment_id", commentId);
        return ResultBodyUtil.success(replyMapper.selectList(queryWrapper));
    }

    @Override
    public ResultBody deleteReply(Reply reply) {
            replyMapper.deleteById(reply);
            return ResultBodyUtil.success();
    }
}
