package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Reply;
import com.jxkj.managecenter.service.IReplyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 回复表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("blogCenter/reply")
@Api(tags = "博客回复评论模块 接口")
@Slf4j
public class ReplyController {

    @Autowired
    private IReplyService iReplyService;

    @ApiOperation(value = "查询当前评论的回复")
    @GetMapping("/listReply")
    public ResultBody listReply(Long commentId){
        return iReplyService.listReply(commentId);
    }

    @ApiOperation(value = "留言回复")
    @PostMapping("/saveReply")
    public ResultBody saveReply(Reply reply){
        //TODO 获取回复用户的信息
        iReplyService.save(reply);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "删除回复")
    @PostMapping("/deleteReply")
    public ResultBody deleteReply(Reply reply){
        return iReplyService.deleteReply(reply);
    }
}
