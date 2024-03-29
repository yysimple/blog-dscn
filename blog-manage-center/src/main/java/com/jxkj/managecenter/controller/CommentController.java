package com.jxkj.managecenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.Comment;
import com.jxkj.managecenter.service.ICommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 评论表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-19
 */
@RestController
@RequestMapping("comment")
@Api(tags = "博客留言模块 接口")
@Slf4j
public class CommentController {

    @Autowired
    private ICommentService iCommentService;

    @ApiOperation(value = "分页查询当前博客所有评论")
    @GetMapping("/listComment")
    public ResultBody listComment(@RequestParam("tBlogInfoId") Long tBlogInfoId) {
        return iCommentService.listComment(tBlogInfoId);
    }

    @ApiOperation(value = "提交留言")
    @PostMapping("/commitComment")
    public ResultBody commitComment(@RequestBody Comment comment) {
        iCommentService.saveComment(comment);
        return ResultBodyUtil.success();
    }

    @ApiOperation(value = "删除留言")
    @PostMapping("/deleteComment")
    public ResultBody deleteComment(@RequestParam("id") Long id) {
        iCommentService.removeById(id);
        return ResultBodyUtil.success();
    }
}
